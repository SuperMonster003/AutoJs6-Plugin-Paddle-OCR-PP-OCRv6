******

### 发行历史

******

# v1.0.1

###### 2026/09/11

* `优化` 构建阶段校验 64 位原生库的 16 KB 页大小对齐, 检查 manifest 契约并输出 JSON 报告

# v1.0.0

###### 2026/09/01

* `新增` Paddle OCR PP-OCRv6 插件服务, 插件 ID 包括 `paddle-ocr-pp-ocrv6-tiny`, `paddle-ocr-pp-ocrv6-small` 和 `paddle-ocr-pp-ocrv6-medium`, 引擎为 `paddle-ocr`, 变体为 `v6`
* `新增` 支持通过共享 OCR AIDL action `org.autojs.plugin.PADDLE_OCR` 发现并调用插件
* `新增` 提供 `recognizeText` 和 `detect` 接口, 返回识别文本, 置信度, 文本行边界框, 四点坐标和检测/识别耗时
* `新增` 提供 Tiny, Small, Medium 三个模型档位, 其中 `small` 为 Android 推荐默认档
* `新增` 支持编码图片输入和 `ARGB_8888` 原始图片缓冲区输入
* `新增` 提供 PP-OCRv6 模型资产准备脚本, 支持下载官方 ONNX 模型, 也支持通过 `--source-dir` 转换本地 Paddle 静态模型
* `新增` 插件信息和使用说明的多语言资源: 西班牙语/法语/俄语/阿拉伯语/日语/韩语/英语/简体中文/香港繁体/台湾繁体
* `新增` README 和 CHANGELOG 的 JSON 源文件及 `.python/generate_markdown.py` 生成流程
* `新增` 按 ABI 构建 APK, 包括 `arm64-v8a`/`armeabi-v7a` 以及 `universal` 通用包
* `新增` 发布 APK 文件名包含版本号, flavor, ABI 变体, 发布归档任务可追加 CRC32 摘要
* `修复` 部分系统安装后无法通过插件中心激活的问题
* `优化` 统一 README 版式与 Gradle 平台版本管理方式
