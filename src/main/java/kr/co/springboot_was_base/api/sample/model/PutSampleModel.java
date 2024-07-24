package kr.co.springboot_was_base.api.sample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Schema(description = "Put 샘플 모델")
public class PutSampleModel {

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Schema(description = "Put 샘플 요청 모델 (Request path , query의 schema 정보는 컨트롤러에 parameter 어노테이션 내에 기입)")
    public static class Request {

        @Schema(description = "Put parameter 값 테스트")
        @NotBlank(message = "sampleKey 필수입니다.")
        private String sampleKey;

    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class RequestBody {

        @Schema(description = "핸드폰 번호 테스트", example = "010-0000-0000" , type = "string")
        @NotBlank(message = "phoneNumber 필수입니다.")
        @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "올바른 핸드폰 번호 형식을 입력해 주세요.")
        private String phoneNumber;

        @Schema(description = "이메일 테스트", example = "save7412@naver.com" , type = "string")
        @NotBlank(message = "email 필수입니다.")
        @Email(message = "올바른 이메일 형식을 입력해 주세요.")
        //@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "올바른 이메일 형식을 입력해 주세요.")
        private String email;

        @Schema(description = "공백불가변수 테스트", example = "공백없음" , type = "string")
        @NotBlank(message = "noWhitespace 필수입니다.")
        @Pattern(regexp = "^\\S*$", message = "공백이 포함되어 있습니다.")
        private String noWhitespace;

        @Schema(description = "Body  정수형 테스트", example = "10")
        @NotNull(message = "integerBody 필수입니다.")
        @Min(value = 1 , message = "1 미만의 값은 사용하실 수 없습니다.")
        @Max(value = 20 , message = "21 이상의 값은 사용하실 수 없습니다.")
        private Integer integerBody;

        @Schema(description = "Body  실수형 테스트", example = "1.0")
        @NotNull(message = "numberBody 필수입니다.")
        @DecimalMin(value = "0.5" , message = "0.5 미만의 값은 사용하실 수 없습니다.")
        @DecimalMax(value = "5.0" , message = "5.1 이상의 값은 사용하실 수 없습니다.")
        private Double numberBody;

        @Schema(description = "Body  문자열 테스트", example = "stringBody")
        @NotBlank(message = "stringBody 필수입니다.")
        @Size(min = 1 , max = 50 , message = "1에서 50자 사이만 가능합니다.")
        private String stringBody;

        @Schema(description = "Body  불린형 테스트", example = "false")
        @NotNull(message = "booleanBody 필수입니다.")
        @AssertFalse(message = "false 만을 사용해주세요.")
        private Boolean booleanBody;

        @Schema(description = "Body  배열형 테스트", example = "[\"고\",\"기\",\"가\",\"가\",\"가\",\"기\",\"고\"]")
        @NotNull(message = "arrayBody 필수입니다.")
        @Size(min = 5 , message = "6개 이상의 데이터를 보내주세요")
        private List<String> arrayBody;

        @Schema(description = "jsonIgnore 테스트", example = "ignore")
        @JsonIgnore
        private String jsonIgnore;
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Schema(description = "Put 샘플 응답 모델")
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
