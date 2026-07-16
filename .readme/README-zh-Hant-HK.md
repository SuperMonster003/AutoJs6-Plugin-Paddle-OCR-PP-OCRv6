<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-paddle-ocr-pp-ocrv6-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>用於本地 OCR 的 Paddle OCR PP-OCRv6 插件</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/commit/c0ce9cff35143c09cb1811c487a306e5b4ef2399"><img alt="Created" src="https://img.shields.io/date/1783150107?color=2e7d32&label=Created"/></a>
    <br>
    <a href="https://developer.android.com/studio/archive"><img alt="Android Studio" src="https://img.shields.io/badge/Android%20Studio-2023.3+-B64FC8"/></a>
    <a href="https://www.jetbrains.com/idea/download/other.html"><img alt="IntelliJ IDEA" src="https://img.shields.io/badge/IntelliJ%20IDEA-2023.3+-EE4677"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?color=534BAE&label=License"/></a>
  </p>
</div>

******

### 語言 (Languages)

******

目前 README.md 支援以下語言:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hans.md)
- 繁體中文 (香港) [zh-Hant-HK] # 目前
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-ar.md)

******

### 簡介

******

AutoJs6 Paddle OCR PP-OCRv6 插件為 AutoJs6 提供基於 Paddle OCR PP-OCRv6 的本地文字檢測和識別能力, 可按 Tiny, Small, Medium 三個模型檔位構建獨立 APK.

******

### 功能

******

- 提供共享 OCR 插件服務, 插件 ID 為 `paddle-ocr-pp-ocrv6-tiny / paddle-ocr-pp-ocrv6-small / paddle-ocr-pp-ocrv6-medium`, 引擎為 `paddle-ocr`, 變體為 `v6`.
- 通過 `org.autojs.plugin.PADDLE_OCR` 暴露 OCR AIDL 接口, 兼容 AutoJs6 宿主側 OCR 插件發現機制.
- 支援 `recognizeText` 返回文本行列表, 支援 `detect` 返回文本, 置信度, 文本行邊界框, 四點坐標和耗時資訊.
- 支援編碼圖片輸入和 `ARGB_8888` 原始圖片緩衝區輸入.
- `small` 為 Android 推薦默認檔, `tiny` 面向低端設備和最快本地 OCR, `medium` 面向高精度 OCR.
- 提供 `scripts/prepare_ppocrv6_assets.py` 準備 PP-OCRv6 模型資產, 並按 flavor 放入獨立 assets 目錄.
- 插件資訊, 使用說明, README 與 CHANGELOG 均支援西班牙語/法語/俄語/阿拉伯語/日語/韓語/英語/簡體中文/香港繁體/台灣繁體.
- 基於 `com.microsoft.onnxruntime:onnxruntime-android` 和 OpenCV 4.8.0.

******

### 模型檔位

******

```text
tiny: 面向低端設備和最快本地 OCR
small: Android 推薦默認檔
medium: 使用更大模型資產的高精度 OCR
```

每個檔位都作為獨立 product flavor 打包, APK 只包含對應模型資產

******

### 插件接口

******

宿主可通過以下身份發現並調用插件:

```text
action: org.autojs.plugin.PADDLE_OCR
engine: paddle-ocr
variant: v6
plugin ids: paddle-ocr-pp-ocrv6-tiny / paddle-ocr-pp-ocrv6-small / paddle-ocr-pp-ocrv6-medium
```

`recognizeText` 返回字符串列表; `detect` 返回 OCR 結果列表, 每項包含 `text`, `confidence`, `bounds`, `quad`, `detectionTimeMs`, `recognitionTimeMs`, `totalTimeMs` 和 `coldLoadTimeMs`.

******

### 模型資產

******

```powershell
python scripts/prepare_ppocrv6_assets.py --profile small
python scripts/prepare_ppocrv6_assets.py --profile tiny
python scripts/prepare_ppocrv6_assets.py --profile medium
```

腳本會下載官方 PP-OCRv6 ONNX 資產, 或在提供 `--source-dir` 時轉換本地 Paddle 靜態模型歸檔. 默認寫入 `app/src/<profile>/assets`.

******

### 發行歷史

******

# v1.0.0

###### 2026/07/17

* `新增` Paddle OCR PP-OCRv6 插件服務, 插件 ID 包括 `paddle-ocr-pp-ocrv6-tiny`, `paddle-ocr-pp-ocrv6-small` 和 `paddle-ocr-pp-ocrv6-medium`, 引擎為 `paddle-ocr`, 變體為 `v6`
* `新增` 支援通過共享 OCR AIDL action `org.autojs.plugin.PADDLE_OCR` 發現並調用插件
* `新增` 提供 `recognizeText` 和 `detect` 接口, 返回識別文本, 置信度, 文本行邊界框, 四點坐標和檢測/識別耗時
* `新增` 提供 Tiny, Small, Medium 三個模型檔位, 其中 `small` 為 Android 推薦默認檔
* `新增` 支援編碼圖片輸入和 `ARGB_8888` 原始圖片緩衝區輸入
* `新增` 提供 PP-OCRv6 模型資產準備腳本, 支援下載官方 ONNX 模型, 也支援通過 `--source-dir` 轉換本地 Paddle 靜態模型
* `新增` 插件資訊和使用說明的多語言資源: 西班牙語/法語/俄語/阿拉伯語/日語/韓語/英語/簡體中文/香港繁體/台灣繁體
* `新增` README 和 CHANGELOG 的 JSON 源文件及 `.python/generate_markdown.py` 生成流程
* `新增` 按 ABI 構建 APK, 包括 `arm64-v8a`/`armeabi-v7a` 以及 `universal` 通用包
* `新增` 發佈 APK 文件名包含版本號, flavor, ABI 變體, 發佈歸檔任務可追加 CRC32 摘要

##### 更多發行歷史可參閱

* [CHANGELOG-zh-Hant-HK.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.changelog/CHANGELOG-zh-Hant-HK.md)

******

### 構建

******

```powershell
.\gradlew.bat :app:assembleSmallDebug
.\gradlew.bat :app:assembleTinyDebug
.\gradlew.bat :app:assembleMediumDebug
```

Release 構建:

```powershell
.\gradlew.bat :app:assembleSmallRelease
.\gradlew.bat :app:assembleTinyRelease
.\gradlew.bat :app:assembleMediumRelease
```

構建參數來自 `version.properties`, app 最低 SDK 為 26, 目標 SDK 為 36.

******

### 資源結構

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/assets/doc/CHANGELOG-*.md
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml` 提供插件描述本地化; `plugin_instruction.md` 提供宿主側展示的插件使用說明. README 與 CHANGELOG 由 `.python/generate_markdown.py` 根據 JSON 源文件生成.

******

### 相關連結

******

- AutoJs6 文件: https://docs.autojs6.com
- PaddleOCR 官方項目: https://github.com/PaddlePaddle/PaddleOCR
- PaddleX 官方項目: https://github.com/PaddlePaddle/PaddleX
