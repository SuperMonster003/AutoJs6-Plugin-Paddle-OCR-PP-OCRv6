Paddle OCR PP-OCRv6 透過 AutoJs6 共享 OCR 外掛介面提供本機文字偵測和辨識能力.

外掛身分:

- action: `org.autojs.plugin.PADDLE_OCR`
- engine: `paddle-ocr`
- variant: `v6`
- plugin ids: `paddle-ocr-pp-ocrv6-tiny`, `paddle-ocr-pp-ocrv6-small`, `paddle-ocr-pp-ocrv6-medium`

`recognizeText` 回傳辨識文字行. `detect` 回傳文字, 信賴度, 文字行邊界框, 四點座標和耗時資訊.

外掛支援編碼圖片輸入和 `ARGB_8888` 原始圖片緩衝區輸入. `small` 是 Android 建議預設檔, `tiny` 面向低階裝置和最快本機 OCR, `medium` 面向使用更大模型資產的高精度 OCR.
