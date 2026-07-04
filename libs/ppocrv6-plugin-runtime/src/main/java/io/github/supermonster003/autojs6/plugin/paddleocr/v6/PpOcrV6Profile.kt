package io.github.supermonster003.autojs6.plugin.paddleocr.v6

enum class PpOcrV6Profile(
    val value: String,
    val detAssetPath: String,
    val recAssetPath: String,
    val recConfigAssetPath: String,
    val recommendedForMobileDefault: Boolean,
) {
    TINY(
        value = "Tiny",
        detAssetPath = "models/ppocrv6-tiny/det/inference.onnx",
        recAssetPath = "models/ppocrv6-tiny/rec/inference.onnx",
        recConfigAssetPath = "models/ppocrv6-tiny/rec/inference.yml",
        recommendedForMobileDefault = false,
    ),
    SMALL(
        value = "Small",
        detAssetPath = "models/ppocrv6-small/det/inference.onnx",
        recAssetPath = "models/ppocrv6-small/rec/inference.onnx",
        recConfigAssetPath = "models/ppocrv6-small/rec/inference.yml",
        recommendedForMobileDefault = true,
    ),
    MEDIUM(
        value = "Medium",
        detAssetPath = "models/ppocrv6-medium/det/inference.onnx",
        recAssetPath = "models/ppocrv6-medium/rec/inference.onnx",
        recConfigAssetPath = "models/ppocrv6-medium/rec/inference.yml",
        recommendedForMobileDefault = false,
    );

    companion object {
        internal fun fromConfig(config: PpOcrV6RuntimeConfig): PpOcrV6Profile {
            return values().firstOrNull { it.value == config.modelProfile } ?: SMALL
        }
    }
}
