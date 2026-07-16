Paddle OCR PP-OCRv6 は AutoJs6 の共有 OCR プラグインインターフェイスを通じてローカル文字検出と認識を提供します.

プラグイン識別情報:

- action: `org.autojs.plugin.PADDLE_OCR`
- engine: `paddle-ocr`
- variant: `v6`
- plugin ids: `paddle-ocr-pp-ocrv6-tiny`, `paddle-ocr-pp-ocrv6-small`, `paddle-ocr-pp-ocrv6-medium`

`recognizeText` は認識したテキスト行を返します. `detect` はテキスト, 信頼度, 行境界, 四点座標, 時間メタデータを返します.

このプラグインはエンコード画像入力と raw `ARGB_8888` 画像バッファを受け付けます. Android 推奨デフォルトには `small`, 低性能端末と最速ローカル OCR には `tiny`, より大きいモデルアセットで高精度 OCR を行う場合は `medium` を使用します.
