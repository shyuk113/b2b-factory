package com.example.factory.product.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ProductUpdateRequest(
        @NotBlank(message = "상품명은 필수 입력 값입니다.")
        String name,

        @NotBlank(message = "카테고리 필수 입력 값입니다.")
        String category,

        @NotBlank(message = "용도는 필수 입력 값입니다.")
        String usageType,

        @PositiveOrZero(message = "가로 길이는 0보다 커야 합니다.")
        int widthMm,

        @PositiveOrZero(message = "세로 길이는 0보다 커야 합니다.")
        int lengthMm,

        @PositiveOrZero(message = "두께는 0보다 커야 합니다.")
        int thicknessMm,

        @PositiveOrZero(message = "압축강도는 0보다 커야 합니다.")
        int compressiveStrength,

        @NotBlank(message = "색상은 필수 입력 값입니다.")
        String color,

        @NotBlank(message = "인증번호는 필수 입력 값입니다.")
        String ksCertNumber,

        @NotNull(message = "전시 여부(true/false)를 선택해 주세요.")
        Boolean active) {
}
