#!/usr/bin/env python3

import argparse
import shutil
import subprocess
import tarfile
import urllib.request
from pathlib import Path
from typing import Optional

BOS_BASE = "https://paddle-model-ecology.bj.bcebos.com/paddlex/official_inference_model/paddle3.0.0"

ONNX_MODELS = {
    "small": {
        "det": f"{BOS_BASE}/PP-OCRv6_small_det_onnx_infer.tar",
        "rec": f"{BOS_BASE}/PP-OCRv6_small_rec_onnx_infer.tar",
    },
    "tiny": {
        "det": f"{BOS_BASE}/PP-OCRv6_tiny_det_onnx_infer.tar",
        "rec": f"{BOS_BASE}/PP-OCRv6_tiny_rec_onnx_infer.tar",
    },
    "medium": {
        "det": f"{BOS_BASE}/PP-OCRv6_medium_det_onnx_infer.tar",
        "rec": f"{BOS_BASE}/PP-OCRv6_medium_rec_onnx_infer.tar",
    },
}

PADDLE_STATIC_MODELS = {
    "medium": {
        "det": f"{BOS_BASE}/PP-OCRv6_medium_det_infer.tar",
        "rec": f"{BOS_BASE}/PP-OCRv6_medium_rec_infer.tar",
    },
}


def download(url: str, target: Path) -> None:
    target.parent.mkdir(parents=True, exist_ok=True)
    if target.exists() and target.stat().st_size > 0:
        print(f"skip: {target}")
        return
    print(f"download: {url}")
    urllib.request.urlretrieve(url, target)


def resolve_local_model_tar(source_dir: Optional[Path], profile: str, kind: str) -> Optional[Path]:
    if source_dir is None:
        return None
    candidates = [
        source_dir / f"PP-OCRv6_{profile}_{kind}_onnx_infer.tar",
        source_dir / f"PP-OCRv6_{profile}_{kind}_infer.tar",
        source_dir / f"{profile}-{kind}.tar",
        source_dir / f"{profile}-{kind}-onnx.tar",
    ]
    return next((candidate for candidate in candidates if candidate.is_file()), None)


def safe_extract_tar(tar_path: Path, out_dir: Path) -> Path:
    out_dir.mkdir(parents=True, exist_ok=True)
    base = out_dir.resolve()
    with tarfile.open(tar_path) as archive:
        for member in archive.getmembers():
            target = (out_dir / member.name).resolve()
            if base not in target.parents and target != base:
                raise RuntimeError(f"unsafe tar member: {member.name}")
        try:
            archive.extractall(out_dir, filter="data")
        except TypeError:
            archive.extractall(out_dir)

    children = [p for p in out_dir.iterdir() if p.is_dir()]
    return children[0] if len(children) == 1 else out_dir


def copy_onnx_model(extracted_dir: Path, dst_dir: Path) -> None:
    dst_dir.mkdir(parents=True, exist_ok=True)
    onnx = next(extracted_dir.rglob("inference.onnx"), None)
    yml = next(extracted_dir.rglob("inference.yml"), None)
    if onnx is None:
        raise FileNotFoundError(f"inference.onnx not found under {extracted_dir}")
    shutil.copy2(onnx, dst_dir / "inference.onnx")
    if yml is not None:
        shutil.copy2(yml, dst_dir / "inference.yml")


def has_onnx_model(extracted_dir: Path) -> bool:
    return next(extracted_dir.rglob("inference.onnx"), None) is not None


def convert_paddle_to_onnx(paddle_model_dir: Path, onnx_output_dir: Path) -> None:
    onnx_output_dir.mkdir(parents=True, exist_ok=True)
    paddle2onnx = shutil.which("paddle2onnx")
    commands = []
    if paddle2onnx:
        commands.append([
            paddle2onnx,
            "--model_dir",
            str(paddle_model_dir),
            "--save_file",
            str(onnx_output_dir / "inference.onnx"),
            "--opset_version",
            "7",
        ])
    commands.append([
        "paddlex",
        "--paddle2onnx",
        "--paddle_model_dir",
        str(paddle_model_dir),
        "--onnx_model_dir",
        str(onnx_output_dir),
        "--opset_version",
        "7",
    ])
    last_error = None
    for cmd in commands:
        print("run:", " ".join(cmd))
        try:
            subprocess.check_call(cmd)
            break
        except subprocess.CalledProcessError as exc:
            last_error = exc
    else:
        if last_error is not None:
            raise last_error
    yml = next(paddle_model_dir.rglob("inference.yml"), None)
    if yml is not None and not (onnx_output_dir / "inference.yml").exists():
        shutil.copy2(yml, onnx_output_dir / "inference.yml")


def profile_assets_root(profile: str, overridden_assets_root: Optional[str]) -> Path:
    if overridden_assets_root:
        return Path(overridden_assets_root)
    return Path("app") / "src" / profile / "assets"


def prepare_small_or_tiny(profile: str, assets_root: Path, cache_dir: Path, source_dir: Optional[Path]) -> None:
    for kind, url in ONNX_MODELS[profile].items():
        tar_path = cache_dir / f"{profile}-{kind}.tar"
        extract_dir = cache_dir / f"{profile}-{kind}"
        dst_dir = assets_root / f"models/ppocrv6-{profile}/{kind}"
        local_tar = resolve_local_model_tar(source_dir, profile, kind)
        if local_tar is not None:
            tar_path.parent.mkdir(parents=True, exist_ok=True)
            shutil.copy2(local_tar, tar_path)
        else:
            download(url, tar_path)
        model_dir = safe_extract_tar(tar_path, extract_dir)
        copy_onnx_model(model_dir, dst_dir)


def prepare_medium(assets_root: Path, cache_dir: Path, source_dir: Optional[Path]) -> None:
    for kind, url in PADDLE_STATIC_MODELS["medium"].items():
        onnx_url = ONNX_MODELS["medium"][kind]
        tar_path = cache_dir / f"medium-{kind}.tar"
        extract_dir = cache_dir / f"medium-{kind}-paddle"
        onnx_dir = cache_dir / f"medium-{kind}-onnx"
        dst_dir = assets_root / f"models/ppocrv6-medium/{kind}"
        local_tar = resolve_local_model_tar(source_dir, "medium", kind)
        if local_tar is not None:
            tar_path.parent.mkdir(parents=True, exist_ok=True)
            shutil.copy2(local_tar, tar_path)
            paddle_dir = safe_extract_tar(tar_path, extract_dir)
            if has_onnx_model(paddle_dir):
                copy_onnx_model(paddle_dir, dst_dir)
            else:
                convert_paddle_to_onnx(paddle_dir, onnx_dir)
                copy_onnx_model(onnx_dir, dst_dir)
        else:
            onnx_tar_path = cache_dir / f"medium-{kind}-onnx.tar"
            onnx_extract_dir = cache_dir / f"medium-{kind}-onnx-src"
            download(onnx_url, onnx_tar_path)
            onnx_model_dir = safe_extract_tar(onnx_tar_path, onnx_extract_dir)
            copy_onnx_model(onnx_model_dir, dst_dir)


def main() -> None:
    parser = argparse.ArgumentParser()
    parser.add_argument("--profile", choices=["tiny", "small", "medium", "all"], default="small")
    parser.add_argument("--assets-root", default=None)
    parser.add_argument("--cache-dir", default=".cache/ppocrv6")
    parser.add_argument("--source-dir", default=None)
    args = parser.parse_args()

    cache_dir = Path(args.cache_dir)
    source_dir = Path(args.source_dir) if args.source_dir else None
    profiles = ["tiny", "small", "medium"] if args.profile == "all" else [args.profile]
    for profile in profiles:
        assets_root = profile_assets_root(profile, args.assets_root)
        if profile in ("tiny", "small"):
            prepare_small_or_tiny(profile, assets_root, cache_dir, source_dir)
        else:
            prepare_medium(assets_root, cache_dir, source_dir)


if __name__ == "__main__":
    main()
