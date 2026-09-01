******

### 發行歷史

******

# v1.0.0

###### 2026/09/01

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
* `修復` 部分系統安裝後無法透過插件中心激活的問題
* `優化` 統一 README 版式與 Gradle 平台版本管理方式
