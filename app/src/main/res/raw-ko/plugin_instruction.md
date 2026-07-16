Paddle OCR PP-OCRv6는 AutoJs6 공유 OCR 플러그인 인터페이스를 통해 로컬 텍스트 검출과 인식을 제공합니다.

플러그인 식별 정보:

- action: `org.autojs.plugin.PADDLE_OCR`
- engine: `paddle-ocr`
- variant: `v6`
- plugin ids: `paddle-ocr-pp-ocrv6-tiny`, `paddle-ocr-pp-ocrv6-small`, `paddle-ocr-pp-ocrv6-medium`

`recognizeText`는 인식된 텍스트 줄을 반환합니다. `detect`는 텍스트, 신뢰도, 줄 경계, 사각형 좌표, 시간 메타데이터를 반환합니다.

플러그인은 인코딩 이미지 입력과 원시 `ARGB_8888` 이미지 버퍼를 받습니다. Android 권장 기본값으로 `small`, 저사양 기기와 가장 빠른 로컬 OCR에는 `tiny`, 더 큰 모델 자산으로 높은 정확도의 OCR이 필요하면 `medium`을 사용합니다.
