<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-paddle-ocr-pp-ocrv6-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>用於本機 OCR 的 Paddle OCR PP-OCRv6 外掛</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6?color=534BAE&label=License"/></a>
  </p>
</div>

******

### 語言 (Languages)

******

目前 README.md 支援以下語言:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/.readme/README-zh-Hant-HK.md)
- 繁體中文 (台灣) [zh-Hant-TW] # 目前
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

AutoJs6 Paddle OCR PP-OCRv6 外掛為 AutoJs6 提供基於 Paddle OCR PP-OCRv6 的本機文字偵測和辨識能力, 可依 Tiny, Small, Medium 三個模型檔位建置獨立 APK.

******

### 功能

******

- 提供共享 OCR 外掛服務, 外掛 ID 為 `paddle-ocr-pp-ocrv6-tiny / paddle-ocr-pp-ocrv6-small / paddle-ocr-pp-ocrv6-medium`, 引擎為 `paddle-ocr`, 變體為 `v6`.
- 透過 `org.autojs.plugin.PADDLE_OCR` 暴露 OCR AIDL 介面, 相容 AutoJs6 宿主端 OCR 外掛探索機制.
- 支援 `recognizeText` 回傳文字行列表, 支援 `detect` 回傳文字, 信賴度, 文字行邊界框, 四點座標和耗時資訊.
- 支援編碼圖片輸入和 `ARGB_8888` 原始圖片緩衝區輸入.
- `small` 為 Android 建議預設檔, `tiny` 面向低階裝置和最快本機 OCR, `medium` 面向高精度 OCR.
- 提供 `scripts/prepare_ppocrv6_assets.py` 準備 PP-OCRv6 模型資產, 並按 flavor 放入獨立 assets 目錄.
- 外掛資訊, 使用說明, README 與 CHANGELOG 均支援西班牙文/法文/俄文/阿拉伯文/日文/韓文/英文/簡體中文/香港繁體/台灣繁體.
- 基於 `com.microsoft.onnxruntime:onnxruntime-android` 和 OpenCV 4.8.0.

******

### 模型檔位

******

```text
tiny: 面向低階裝置和最快本機 OCR
small: Android 建議預設檔
medium: 使用更大模型資產的高精度 OCR
```

每個檔位都作為獨立 product flavor 打包, APK 只包含對應模型資產

******

### 外掛介面

******

宿主可透過以下身分探索並呼叫外掛:

```text
action: org.autojs.plugin.PADDLE_OCR
engine: paddle-ocr
variant: v6
plugin ids: paddle-ocr-pp-ocrv6-tiny / paddle-ocr-pp-ocrv6-small / paddle-ocr-pp-ocrv6-medium
```

`recognizeText` 回傳字串列表; `detect` 回傳 OCR 結果列表, 每項包含 `text`, `confidence`, `bounds`, `quad`, `detectionTimeMs`, `recognitionTimeMs`, `totalTimeMs` 和 `coldLoadTimeMs`.

******

### 模型資產

******

```powershell
python scripts/prepare_ppocrv6_assets.py --profile small
python scripts/prepare_ppocrv6_assets.py --profile tiny
python scripts/prepare_ppocrv6_assets.py --profile medium
```

腳本會下載官方 PP-OCRv6 ONNX 資產, 或在提供 `--source-dir` 時轉換本機 Paddle 靜態模型封存檔. 預設寫入 `app/src/<profile>/assets`.

******

### 發行歷史

******

# v1.0.2

###### 2026/09/12

* `修復` 修復 16 KB 分頁大小裝置上引擎初始化即當機 (SIGSEGV) 的問題: 隨附的 `libc++_shared.so` 更新為 NDK r28.2 建置版本, 其 RELRO 區段末尾不再與可寫資料共用記憶體頁 (arm64-v8a, armeabi-v7a)
* `修復` 修復載入體積較大的辨識模型時因 `OutOfMemoryError` 而靜默回傳空結果的問題: 模型資源現在只會複製到應用私有目錄一次, 並由 ONNX Runtime 以記憶體映射方式建立工作階段, 不再整體讀入 Java 堆積
* `修復` 部分 Gradle/AGP 組合下 Kotlin 原始碼未參與編譯, 以及重複定義 `WakeActivity` 導致的建置失敗
* `優化` 同步 OpenCV 4.8.0 原生程式庫至 NDK r28c (Clang 19.0.1) 重新建置版本 (donor: AutoJs6-Plugin-OpenCV), 4 個 ABI 的 `libopencv_java4.so` 保持 16 KB `PT_LOAD` 對齊並附帶 provenance 清單

# v1.0.1

###### 2026/09/11

* `優化` 建置階段校驗 64 位原生函式庫的 16 KB 頁面大小對齊, 檢查 manifest 契約並輸出 JSON 報告

# v1.0.0

###### 2026/09/01

* `新增` Paddle OCR PP-OCRv6 外掛服務, 外掛 ID 包括 `paddle-ocr-pp-ocrv6-tiny`, `paddle-ocr-pp-ocrv6-small` 和 `paddle-ocr-pp-ocrv6-medium`, 引擎為 `paddle-ocr`, 變體為 `v6`
* `新增` 支援透過共享 OCR AIDL action `org.autojs.plugin.PADDLE_OCR` 探索並呼叫外掛
* `新增` 提供 `recognizeText` 和 `detect` 介面, 回傳辨識文字, 信賴度, 文字行邊界框, 四點座標和偵測/辨識耗時
* `新增` 提供 Tiny, Small, Medium 三個模型檔位, 其中 `small` 為 Android 建議預設檔
* `新增` 支援編碼圖片輸入和 `ARGB_8888` 原始圖片緩衝區輸入
* `新增` 提供 PP-OCRv6 模型資產準備腳本, 支援下載官方 ONNX 模型, 也支援透過 `--source-dir` 轉換本機 Paddle 靜態模型
* `新增` 外掛資訊和使用說明的多語言資源: 西班牙文/法文/俄文/阿拉伯文/日文/韓文/英文/簡體中文/香港繁體/台灣繁體
* `新增` README 和 CHANGELOG 的 JSON 來源檔及 `.python/generate_markdown.py` 產生流程
* `新增` 依 ABI 建置 APK, 包括 `arm64-v8a`/`armeabi-v7a` 以及 `universal` 通用套件
* `新增` 發佈 APK 檔名包含版本號, flavor, ABI 變體, 發佈歸檔任務可追加 CRC32 摘要
* `修復` 部分系統安裝後無法透過外掛中心啟用的問題
* `優化` 統一 README 版式與 Gradle 平台版本管理方式

##### 更多發行歷史可參閱

* [CHANGELOG-zh-Hant-TW.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/app/src/main/assets/doc/CHANGELOG-zh-Hant-TW.md)

******

### 建置

******

```powershell
.\gradlew.bat :app:assembleSmallDebug
.\gradlew.bat :app:assembleTinyDebug
.\gradlew.bat :app:assembleMediumDebug
```

Release 建置:

```powershell
.\gradlew.bat :app:assembleSmallRelease
.\gradlew.bat :app:assembleTinyRelease
.\gradlew.bat :app:assembleMediumRelease
```

建置參數來自 `version.properties`, app 最低 SDK 為 26, 目標 SDK 為 36.

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

`strings.xml` 提供外掛描述在地化; `plugin_instruction.md` 提供宿主端展示的外掛使用說明. README 與 CHANGELOG 由 `.python/generate_markdown.py` 根據 JSON 來源檔產生.

******

### 相關連結

******

- AutoJs6 文件: https://docs.autojs6.com
- PaddleOCR 官方專案: https://github.com/PaddlePaddle/PaddleOCR
- PaddleX 官方專案: https://github.com/PaddlePaddle/PaddleX


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Paddle-OCR-PP-OCRv6/blob/master/docs/16kb.md)
