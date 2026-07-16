Paddle OCR PP-OCRv6 通过 AutoJs6 共享 OCR 插件接口提供本地文字检测和识别能力.

插件身份:

- action: `org.autojs.plugin.PADDLE_OCR`
- engine: `paddle-ocr`
- variant: `v6`
- plugin ids: `paddle-ocr-pp-ocrv6-tiny`, `paddle-ocr-pp-ocrv6-small`, `paddle-ocr-pp-ocrv6-medium`

`recognizeText` 返回识别文本行. `detect` 返回文本, 置信度, 文本行边界框, 四点坐标和耗时信息.

插件支持编码图片输入和 `ARGB_8888` 原始图片缓冲区输入. `small` 是 Android 推荐默认档, `tiny` 面向低端设备和最快本地 OCR, `medium` 面向使用更大模型资产的高精度 OCR.
