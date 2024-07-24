package kr.co.springboot_was_base.api.sample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Schema(description = "Get 샘플 모델")
public class GetSampleModel {

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Schema(description = "Get 샘플 요청 모델 (Request path , query의 schema 정보는 컨트롤러에 parameter 어노테이션 내에 기입)")
    public static class Request {

        @Schema(description = "path parameter 값 테스트")
        @NotBlank(message = "sampleKey 필수입니다.")
        private String sampleKey;

        @Schema(description = "query parameter 정수형 테스트")
        @NotNull(message = "integerQuery 필수입니다.")
        @Min(value = 1 , message = "1 미만의 값은 사용하실 수 없습니다.")
        @Max(value = 20 , message = "21 이상의 값은 사용하실 수 없습니다.")
        private Integer integerQuery;

        @Schema(description = "query parameter 실수형 테스트")
        @NotNull(message = "numberQuery 필수입니다.")
        @DecimalMin(value = "0.5" , message = "0.5 미만의 값은 사용하실 수 없습니다.")
        @DecimalMax(value = "5.0" , message = "5.1 이상의 값은 사용하실 수 없습니다.")
        private Double numberQuery;

        @Schema(description = "query parameter 문자열 테스트")
        @NotBlank(message = "stringQuery 필수입니다.")
        @Size(min = 1 , max = 50 , message = "1에서 50자 사이만 가능합니다.")
        private String stringQuery;

        @Schema(description = "query parameter 불린형 테스트")
        @NotNull(message = "booleanQuery 필수입니다.")
        @AssertTrue(message = "true 만을 사용해주세요.")
        //@AssertFalse(message = "false 만을 사용해주세요.")
        private Boolean booleanQuery;

        @Schema(description = "query parameter 배열형 테스트")
        @NotNull(message = "arrayQuery 필수입니다.")
        @Size(min = 5 , message = "6개 이상의 데이터를 보내주세요")
        private List<String> arrayQuery;

        @Schema(description = "jsonIgnore 테스트")
        @JsonIgnore
        private String jsonIgnore;

    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Schema(description = "Get 샘플 요청 응답 모델")
    public static class Response {

        @Schema(description = "핸드폰 번호")
        private String phoneNumber;

        @Schema(description = "이메일")
        private String email;

        @Schema(description = "공백불가변수")
        private String noWhitespace;

        @Schema(description = "정수형")
        private Integer integerBody;

        @Schema(description = "실수형")
        private Double numberBody;

        @Schema(description = "문자열")
        private String stringBody;

        @Schema(description = "불린형")
        private Boolean booleanBody;

        @Schema(description = "배열형")
        private List<String> arrayBody;

    }
}
