# v1.0.0

###### 2026/07/17

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
