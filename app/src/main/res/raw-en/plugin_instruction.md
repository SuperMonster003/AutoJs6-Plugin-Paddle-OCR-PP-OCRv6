Paddle OCR PP-OCRv6 provides local text detection and recognition through the shared AutoJs6 OCR plugin interface.

Plugin identity:

- action: `org.autojs.plugin.PADDLE_OCR`
- engine: `paddle-ocr`
- variant: `v6`
- plugin ids: `paddle-ocr-pp-ocrv6-tiny`, `paddle-ocr-pp-ocrv6-small`, `paddle-ocr-pp-ocrv6-medium`

`recognizeText` returns recognized text lines. `detect` returns text, confidence, line bounds, quadrilateral coordinates, and timing metadata.

The plugin accepts encoded image input and raw `ARGB_8888` image buffers. Use `small` as the recommended Android default, `tiny` for low-end devices and fastest local OCR, and `medium` for higher-accuracy OCR with larger model assets.
