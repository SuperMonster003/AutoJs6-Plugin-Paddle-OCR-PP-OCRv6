<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-paddle-ocr-pp-ocrv6-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>ローカル OCR 用 Paddle OCR PP-OCRv6 プラグイン</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?color=534BAE&label=License"/></a>
  </p>
</div>

******

### 言語 (Languages)

******

現在の README.md は次の言語に対応しています:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-es.md)
- 日本語 [ja] # 現在
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ar.md)

******

### 概要

******

AutoJs6 Paddle OCR PP-OCRv6 プラグインは, Paddle OCR PP-OCRv6 によるローカル文字検出と認識を AutoJs6 に提供します. Tiny, Small, Medium のモデルプロファイルごとに個別の APK をビルドします.

******

### 機能

******

- プラグイン ID `paddle-ocr-pp-ocrv6-tiny / paddle-ocr-pp-ocrv6-small / paddle-ocr-pp-ocrv6-medium`, エンジン `paddle-ocr`, バリアント `v6` の共有 OCR プラグインサービスを提供します.
- `org.autojs.plugin.PADDLE_OCR` 経由で OCR AIDL インターフェイスを公開し, AutoJs6 ホストの OCR プラグイン検出フローに対応します.
- `recognizeText` はテキスト行リストを返し, `detect` はテキスト, 信頼度, 行境界, 四点座標, 時間メタデータを返します.
- エンコード画像入力と raw `ARGB_8888` 画像バッファ入力に対応します.
- `small` は Android 推奨デフォルト, `tiny` は低性能端末と最速ローカル OCR 向け, `medium` は高精度 OCR 向けです.
- `scripts/prepare_ppocrv6_assets.py` で PP-OCRv6 モデルアセットを準備し, 各プロファイルを個別の flavor assets ディレクトリに配置します.
- プラグインメタデータ, 使用説明, README, CHANGELOG はスペイン語/フランス語/ロシア語/アラビア語/日本語/韓国語/英語/簡体字中国語/香港繁体字/台湾繁体字にローカライズされています.
- `com.microsoft.onnxruntime:onnxruntime-android` と OpenCV 4.8.0 を基盤にしています.
- 画像は最大 16777216 ピクセルまで, 生画像バッファーは 64 MiB まで対応
- エンコード済み画像は 64 MiB まで対応し ファイル記述子とパイプを使用できます

******

### モデルプロファイル

******

```text
tiny: 低性能端末と最速ローカル OCR
small: Android 推奨デフォルト
medium: 大きいモデルアセットを使う高精度 OCR
```

各プロファイルは個別の product flavor としてパッケージされ, APK には選択されたモデルアセットのみが含まれます

******

### プラグインインターフェイス

******

ホストは次の識別情報でプラグインを検出して呼び出せます:

```text
action: org.autojs.plugin.PADDLE_OCR
engine: paddle-ocr
variant: v6
plugin ids: paddle-ocr-pp-ocrv6-tiny / paddle-ocr-pp-ocrv6-small / paddle-ocr-pp-ocrv6-medium
```

`recognizeText` は文字列リストを返します; `detect` は `text`, `confidence`, `bounds`, `quad`, `detectionTimeMs`, `recognitionTimeMs`, `totalTimeMs`, `coldLoadTimeMs` を含む OCR 結果オブジェクトを返します.

******

### モデルアセット

******

```powershell
python scripts/prepare_ppocrv6_assets.py --profile small
python scripts/prepare_ppocrv6_assets.py --profile tiny
python scripts/prepare_ppocrv6_assets.py --profile medium
```

スクリプトは公式 PP-OCRv6 ONNX アセットをダウンロードします. `--source-dir` が指定された場合はローカル Paddle 静的モデルアーカイブを変換します. デフォルトでは `app/src/<profile>/assets` に書き込みます.

******

### リリース履歴

******

# v1.0.3

###### 2026/09/13

* `修正` プラグインセンターのバージョンと ABI 情報がインストール済み APK と一致
* `修正` エンコード済み画像は 64 MiB まで対応し ファイル記述子とパイプを使用できます
* `改善` ダウンロード用ファイルの作成前に, リリース APK のバージョン, 署名, バリアントの完全性を検証
* `改善` 画像は最大 16777216 ピクセルまで, 生画像バッファーは 64 MiB まで対応

# v1.0.2

###### 2026/09/12

* `修正` 16 KB ページサイズ端末でエンジン初期化時にクラッシュ (SIGSEGV) する問題を修正: 同梱の `libc++_shared.so` を NDK r28.2 ビルドに更新し, RELRO セグメントが書き込み可能データとページを共有しないように (arm64-v8a, armeabi-v7a)
* `修正` 大きな認識モデルの読み込み時に `OutOfMemoryError` が発生して空の結果が返される問題を修正: モデルアセットをアプリ専用ストレージへ一度だけ展開し, Java ヒープに読み込む代わりに ONNX Runtime がメモリマップするように
* `修正` 一部の Gradle/AGP の組み合わせで Kotlin ソースがコンパイルされず, `WakeActivity` の重複定義によりビルドが失敗する問題
* `改善` OpenCV 4.8.0 ネイティブライブラリを NDK r28c (Clang 19.0.1) 再ビルド版に同期 (donor: AutoJs6-Plugin-OpenCV); 4 つの ABI の `libopencv_java4.so` は 16 KB `PT_LOAD` アラインメントを維持し provenance マニフェストを同梱

# v1.0.1

###### 2026/09/11

* `改善` 64 ビットのネイティブライブラリの 16 KB ページアラインメントをビルド時に検証, manifest 契約の検査と JSON レポートに対応

##### その他のリリース履歴

* [CHANGELOG-ja.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/assets/doc/CHANGELOG-ja.md)

******

### ビルド

******

```powershell
.\gradlew.bat :app:assembleSmallDebug
.\gradlew.bat :app:assembleTinyDebug
.\gradlew.bat :app:assembleMediumDebug
```

Release ビルド:

```powershell
.\gradlew.bat :app:assembleSmallRelease
.\gradlew.bat :app:assembleTinyRelease
.\gradlew.bat :app:assembleMediumRelease
```

ビルドパラメータは `version.properties` から取得されます. app の最小 SDK は 26, ターゲット SDK は 36 です.

******

### リソース構成

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/assets/doc/CHANGELOG-*.md
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml` にはローカライズされたプラグイン説明が含まれます; `plugin_instruction.md` にはホスト側で表示される使用説明が含まれます. README と CHANGELOG は `.python/generate_markdown.py` により JSON ソースから生成されます.

******

### リンク

******

- AutoJs6 ドキュメント: https://docs.autojs6.com
- PaddleOCR 公式プロジェクト: https://github.com/PaddlePaddle/PaddleOCR
- PaddleX 公式プロジェクト: https://github.com/PaddlePaddle/PaddleX


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/docs/16kb.md)
