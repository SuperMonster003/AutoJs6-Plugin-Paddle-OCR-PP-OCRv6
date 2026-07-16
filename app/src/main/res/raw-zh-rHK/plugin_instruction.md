Paddle OCR PP-OCRv6 通過 AutoJs6 共享 OCR 插件接口提供本地文字檢測和識別能力.

插件身份:

- action: `org.autojs.plugin.PADDLE_OCR`
- engine: `paddle-ocr`
- variant: `v6`
- plugin ids: `paddle-ocr-pp-ocrv6-tiny`, `paddle-ocr-pp-ocrv6-small`, `paddle-ocr-pp-ocrv6-medium`

`recognizeText` 返回識別文本行. `detect` 返回文本, 置信度, 文本行邊界框, 四點坐標和耗時資訊.

插件支援編碼圖片輸入和 `ARGB_8888` 原始圖片緩衝區輸入. `small` 是 Android 推薦默認檔, `tiny` 面向低端設備和最快本地 OCR, `medium` 面向使用更大模型資產的高精度 OCR.
