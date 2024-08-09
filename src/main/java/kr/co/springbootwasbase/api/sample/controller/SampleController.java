package kr.co.springbootwasbase.api.sample.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kr.co.springbootwasbase.api.sample.enums.SampleAPIResponseEnum;
import kr.co.springbootwasbase.api.sample.model.*;
import kr.co.springbootwasbase.api.sample.service.SampleService;
import kr.co.springbootwasbase.common.response.model.APIResponseModel;
import kr.co.springbootwasbase.common.response.model.ExceptionResponseModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/sample")
@Tag(name = "0. Sample" , description = "샘플 컨트롤러")
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("/{sampleKey}")
    @Operation(summary = "get Sample" , description = "get api의 샘플 컨트롤러입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "2xx", description = "2xx 공통 규격" , content = @Content(schema = @Schema(implementation = APIResponseModel.class))),
            @ApiResponse(responseCode = "4xx", description = "4xx 공통 규격" , content = @Content(schema = @Schema(implementation = ExceptionResponseModel.class))),
            @ApiResponse(responseCode = "5xx", description = "5xx 공통 규격" , content = @Content(schema = @Schema(implementation = ExceptionResponseModel.class))),
            @ApiResponse(responseCode = "20099001", description = "조회 성공 데이터 규격" , content = @Content(schema = @Schema(implementation = GetSampleModel.Response.class))),
            @ApiResponse(responseCode = "40000000", description = "잘못된 요청입니다." , content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "40100000", description = "api 사용 권한이 없습니다." , content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "40300000", description = "리소스 조회 권한이 없습니다." , content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "40400000", description = "존재하지 않는 리소스입니다." , content = @Content(schema = @Schema(implementation = Void.class)))
    })
    @Parameters({
            @Parameter(name = "sampleKey", description = "path parameter 값 테스트" ,
                    example = "sampleKey" , schema = @Schema(type = "string") , in = ParameterIn.PATH),
            @Parameter(name = "integerQuery", description = "query parameter 정수형 테스트" ,
                    example = "1" , schema = @Schema(type = "integer") , in = ParameterIn.QUERY),
            @Parameter(name = "numberQuery", description = "query parameter 실수형 테스트" ,
                    example = "1.0" , schema = @Schema(type = "number") , in = ParameterIn.QUERY),
            @Parameter(name = "stringQuery", description = "query parameter 문자열 테스트" ,
                    example = "문자열" , schema = @Schema(type = "string") , in = ParameterIn.QUERY),
            @Parameter(name = "booleanQuery", description = "query parameter 불린형 테스트" ,
                    example = "true" , schema = @Schema(type = "boolean") , in = ParameterIn.QUERY),
            @Parameter(name = "arrayQuery", description = "query parameter 배열형 테스트 ",
                    example = "[\"고\",\"기\",\"가\",\"가\",\"가\",\"기\",\"고\"]" ,
                    array = @ArraySchema(schema = @Schema(type = "string" , defaultValue = "StringArray")), in = ParameterIn.QUERY)
    })
    public APIResponseModel<GetSampleModel.Response> getSample(
            @Parameter(hidden = true) @Valid GetSampleModel.Request requestModel) {
        log.info("[SampleController.getSample] start {}" , requestModel.getSampleKey());
        GetSampleModel.Response response = sampleService.getSample(requestModel);
        log.info("[SampleController.getSample] end {}" , response);
        return new APIResponseModel<>(SampleAPIResponseEnum.GET_SAMPLE_SUCCESS , response);
    }

    @PostMapping("/{sampleKey}")
    @Operation(summary = "post Sample" , description = "post api의 샘플 컨트롤러입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "2xx", description = "2xx 공통 규격" , content = @Content(schema = @Schema(implementation = APIResponseModel.class))),
            @ApiResponse(responseCode = "4xx", description = "4xx 공통 규격" , content = @Content(schema = @Schema(implementation = ExceptionResponseModel.class))),
            @ApiResponse(responseCode = "5xx", description = "5xx 공통 규격" , content = @Content(schema = @Schema(implementation = ExceptionResponseModel.class))),
            @ApiResponse(responseCode = "20199002", description = "샘플 저장 성공" , content = @Content(schema = @Schema(implementation = PostSampleModel.Response.class))),
            @ApiResponse(responseCode = "40000000", description = "잘못된 요청입니다." , content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "40100000", description = "api 사용 권한이 없습니다." , content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "40300000", description = "리소스 조회 권한이 없습니다." , content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "40400000", description = "존재하지 않는 리소스입니다." , content = @Content(schema = @Schema(implementation = Void.class)))
    })
    @Parameters({
            @Parameter(name = "sampleKey", description = "path parameter 값 테스트" ,
                    example = "sampleKey" , schema = @Schema(type = "string") , in = ParameterIn.PATH),
            @Parameter(name = "sampleKeyQuery1", description = "sampleKeyQuery1 설명" ,
                    example = "sampleKeyQuery1" , schema = @Schema(type = "string") , in = ParameterIn.QUERY),
            @Parameter(name = "sampleKeyQuery2", description = "sampleKeyQuery2 설명",
                    example = "sampleKeyQuery2" , schema = @Schema(type = "string") , in = ParameterIn.QUERY),
    })
    public APIResponseModel<PostSampleModel.Response> postSample(
            @Parameter(hidden = true) @Valid PostSampleModel.Request requestModel,
            @RequestBody @Valid PostSampleModel.RequestBody requestBody) {
        log.info("[SampleController.postSample] start {}" , requestModel.getSampleKey());
        log.info("[SampleController.postSample] requestModel ? : {}" , requestModel);
        log.info("[SampleController.postSample] requestBody ? : {}" , requestBody);
        PostSampleModel.Response response = sampleService.postSample(requestModel , requestBody);
        log.info("[SampleController.postSample] end {}" , requestModel.getSampleKey());
        return new APIResponseModel<>(SampleAPIResponseEnum.POST_SAMPLE_CREATED , response);
    }

    @PutMapping("/{sampleKey}")
    @Operation(summary = "put Sample" , description = "put api의 샘플 컨트롤러입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "2xx", description = "2xx 공통 규격" , content = @Content(schema = @Schema(implementation = APIResponseModel.class))),
            @ApiResponse(responseCode = "4xx", description = "4xx 공통 규격" , content = @Content(schema = @Schema(implementation = ExceptionResponseModel.class))),
            @ApiResponse(responseCode = "5xx", description = "5xx 공통 규격" , content = @Content(schema = @Schema(implementation = ExceptionResponseModel.class))),
            @ApiResponse(responseCode = "20099003", description = "조회 성공 데이터 규격" , content = @Content(schema = @Schema(implementation = PutSampleModel.Response.class))),
            @ApiResponse(responseCode = "40000000", description = "잘못된 요청입니다." , content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "40100000", description = "api 사용 권한이 없습니다." , content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "40300000", description = "리소스 조회 권한이 없습니다." , content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "40400000", description = "존재하지 않는 리소스입니다." , content = @Content(schema = @Schema(implementation = Void.class)))
    })
    @Parameters({
            @Parameter(name = "sampleKey", description = "put parameter 값 테스트" ,
                    example = "sampleKey" , schema = @Schema(type = "string") , in = ParameterIn.PATH),
    })
    public APIResponseModel<PutSampleModel.Response> putSample(
            @Parameter(hidden = true) @Valid PutSampleModel.Request requestModel,
            @RequestBody @Valid PutSampleModel.RequestBody requestBody) {
        log.info("[SampleController.putSample] start {}" , requestModel.getSampleKey());
        log.info("[SampleController.putSample] requestModel ? : {}" , requestModel);
        log.info("[SampleController.putSample] requestBody ? : {}" , requestBody);
        PutSampleModel.Response response = sampleService.putSample(requestModel , requestBody);
        log.info("[SampleController.putSample] end {}" , requestModel.getSampleKey());
        return new APIResponseModel<>(SampleAPIResponseEnum.PUT_SAMPLE_CREATED , response);
    }

    @PatchMapping("/{sampleKey}")
    @Operation(summary = "patch Sample" , description = "patch api의 샘플 컨트롤러입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "2xx", description = "2xx 공통 규격" , content = @Content(schema = @Schema(implementation = APIResponseModel.class))),
            @ApiResponse(responseCode = "4xx", description = "4xx 공통 규격" , content = @Content(schema = @Schema(implementation = ExceptionResponseModel.class))),
            @ApiResponse(responseCode = "5xx", description = "5xx 공통 규격" , content = @Content(schema = @Schema(implementation = ExceptionResponseModel.class))),
            @ApiResponse(responseCode = "20099004", description = "요소 수정 성공 데이터 규격" , content = @Content(schema = @Schema(implementation = PatchSampleModel.Response.class))),
            @ApiResponse(responseCode = "40000000", description = "잘못된 요청입니다." , content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "40100000", description = "api 사용 권한이 없습니다." , content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "40300000", description = "리소스 조회 권한이 없습니다." , content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "40400000", description = "존재하지 않는 리소스입니다." , content = @Content(schema = @Schema(implementation = Void.class)))
    })
    @Parameters({
            @Parameter(name = "sampleKey", description = "patch parameter 값 테스트" ,
                    example = "sampleKey" , schema = @Schema(type = "string") , in = ParameterIn.PATH),
    })
    public APIResponseModel<PatchSampleModel.Response> patchSample(
            @Parameter(hidden = true) @Valid PatchSampleModel.Request requestModel,
            @RequestBody @Valid PatchSampleModel.RequestBody requestBody) {
        log.info("[SampleController.patchSample] start {}" , requestModel.getSampleKey());
        log.info("[SampleController.patchSample] requestModel ? : {}" , requestModel);
        log.info("[SampleController.patchSample] requestBody ? : {}" , requestBody);
        PatchSampleModel.Response response = sampleService.patchSample(requestModel , requestBody);
        log.info("[SampleController.patchSample] end {}" , requestModel.getSampleKey());
        return new APIResponseModel<>(SampleAPIResponseEnum.PATCH_SAMPLE_CREATED , response , requestBody.toString());
    }

    @DeleteMapping("/{sampleKey}")
    @Operation(summary = "delete Sample" , description = "delete api의 샘플 컨트롤러입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "2xx", description = "2xx 공통 규격" , content = @Content(schema = @Schema(implementation = APIResponseModel.class))),
            @ApiResponse(responseCode = "4xx", description = "4xx 공통 규격" , content = @Content(schema = @Schema(implementation = ExceptionResponseModel.class))),
            @ApiResponse(responseCode = "5xx", description = "5xx 공통 규격" , content = @Content(schema = @Schema(implementation = ExceptionResponseModel.class))),
            @ApiResponse(responseCode = "20499005", description = "리소스 삭제 성공 데이터 규격" , content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "40000000", description = "잘못된 요청입니다." , content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "40100000", description = "api 사용 권한이 없습니다." , content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "40300000", description = "리소스 조회 권한이 없습니다." , content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "40400000", description = "존재하지 않는 리소스입니다." , content = @Content(schema = @Schema(implementation = Void.class)))
    })
    @Parameters({
            @Parameter(name = "sampleKey", description = "delete parameter 값 테스트" ,
                    example = "sampleKey" , schema = @Schema(type = "string") , in = ParameterIn.PATH),
    })
    public APIResponseModel<Void> deleteSample(
            @Parameter(hidden = true) @Valid DeleteSampleModel.Request requestModel){
        log.info("[SampleController.deleteSample] start {}" , requestModel.getSampleKey());
        sampleService.deleteSample(requestModel);
        log.info("[SampleController.deleteSample] end {}" , requestModel.getSampleKey());
        return new APIResponseModel<>(SampleAPIResponseEnum.DELETE_SAMPLE_CREATED);
    }

}




