package kr.co.springbootwasbase.api.sample.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@Schema(description = "Delete 샘플 모델")
public class DeleteSampleModel {

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Schema(description = "Delete 샘플 요청 모델 (Request path , query의 schema 정보는 컨트롤러에 parameter 어노테이션 내에 기입)")
    public static class Request {

        @Schema(description = "Delete parameter 값 테스트")
        @NotBlank(message = "sampleKey 필수입니다.")
        private String sampleKey;

    }
}
