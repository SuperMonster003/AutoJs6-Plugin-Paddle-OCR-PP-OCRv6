# AutoJs6 Paddle OCR PP-OCRv6 Plugin

This project builds independent AutoJs6 OCR plugin APKs for PP-OCRv6 `tiny`, `small`, and `medium` profiles.

Default recommendation:

- `small`: recommended Android default.
- `tiny`: low-end devices and fastest local OCR.
- `medium`: high-accuracy profile. It is intentionally a separate APK/flavor because the model payload is much larger.

Prepare model assets:

```bash
python scripts/prepare_ppocrv6_assets.py --profile small
python scripts/prepare_ppocrv6_assets.py --profile tiny
python scripts/prepare_ppocrv6_assets.py --profile medium
```

By default the script writes assets to flavor source sets such as `app/src/small/assets`, `app/src/tiny/assets`, and `app/src/medium/assets`, so each APK only packages its own model profile.

Build:

```bash
./gradlew :app:assembleSmallDebug
./gradlew :app:assembleTinyDebug
./gradlew :app:assembleMediumDebug
```

If you only have Paddle static inference tar files, pass them as a local source and keep PaddleX's `paddle2onnx` plugin available:

```bash
paddlex --install paddle2onnx
python scripts/prepare_ppocrv6_assets.py --profile medium --source-dir /path/to/ppocrv6-medium-static-models
```
