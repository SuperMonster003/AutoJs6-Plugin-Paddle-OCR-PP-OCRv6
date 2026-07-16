Paddle OCR PP-OCRv6 proporciona deteccion y reconocimiento de texto local mediante la interfaz compartida de complementos OCR de AutoJs6.

Identidad del complemento:

- action: `org.autojs.plugin.PADDLE_OCR`
- engine: `paddle-ocr`
- variant: `v6`
- plugin ids: `paddle-ocr-pp-ocrv6-tiny`, `paddle-ocr-pp-ocrv6-small`, `paddle-ocr-pp-ocrv6-medium`

`recognizeText` devuelve lineas de texto reconocidas. `detect` devuelve texto, confianza, limites de linea, coordenadas cuadrilateras y metadatos de tiempo.

El complemento acepta entrada de imagen codificada y buferes de imagen `ARGB_8888` sin procesar. Usa `small` como valor predeterminado recomendado para Android, `tiny` para dispositivos de gama baja y OCR local mas rapido, y `medium` para OCR de mayor precision con activos de modelo mas grandes.
