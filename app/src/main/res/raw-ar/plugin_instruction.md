يوفر Paddle OCR PP-OCRv6 كشف النص والتعرف عليه محليا عبر واجهة مكونات OCR الإضافية المشتركة في AutoJs6.

هوية المكون الإضافي:

- action: `org.autojs.plugin.PADDLE_OCR`
- engine: `paddle-ocr`
- variant: `v6`
- plugin ids: `paddle-ocr-pp-ocrv6-tiny`, `paddle-ocr-pp-ocrv6-small`, `paddle-ocr-pp-ocrv6-medium`

يعيد `recognizeText` أسطر النص المتعرف عليها. يعيد `detect` النص والثقة وحدود السطر وإحداثيات الشكل الرباعي وبيانات الوقت.

يقبل المكون الإضافي إدخال الصور المشفرة ومخازن الصور الخام `ARGB_8888`. استخدم `small` كافتراضي Android الموصى به, و `tiny` للأجهزة الضعيفة وأسرع OCR محلي, و `medium` لـ OCR أعلى دقة مع أصول نموذج أكبر.
