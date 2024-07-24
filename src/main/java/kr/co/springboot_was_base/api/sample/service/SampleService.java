package kr.co.springboot_was_base.api.sample.service;

import kr.co.springboot_was_base.api.sample.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class SampleService {

    public GetSampleModel.Response getSample(GetSampleModel.Request requestModel) {
        log.info("[SampleService.getSample] start {}" , requestModel.getSampleKey());
        log.info("[SampleService.getSample] end {}" , requestModel);
        return GetSampleModel.Response.builder()
                .phoneNumber("010-0000-0000")
                .email("save7412@naver.com")
                .noWhitespace("noWhitespace")
                .integerBody(5)
                .numberBody(3.0)
                .stringBody("stringBody")
                .booleanBody(true)
                .arrayBody(new ArrayList<>(Arrays.asList(
                        "고","기","가","가","가","기","고"
                )))
                .build();
    }
    public PostSampleModel.Response postSample(PostSampleModel.Request requestModel , PostSampleModel.RequestBody requestBody) {
        log.info("[SampleService.postSample] start {}" , requestModel.getSampleKey());
        log.info("[SampleService.postSample] end {}" , requestModel);
        return PostSampleModel.Response.builder()
                .phoneNumber("010-0000-0000")
                .email("save7412@naver.com")
                .noWhitespace("noWhitespace")
                .integerBody(5)
                .numberBody(3.0)
                .stringBody("stringBody")
                .booleanBody(true)
                .arrayBody(new ArrayList<>(Arrays.asList(
                        "고","기","가","가","가","기","고"
                )))
                .build();
    }

    public PatchSampleModel.Response patchSample(PatchSampleModel.Request requestModel , PatchSampleModel.RequestBody requestBody) {
        log.info("[SampleService.patchSample] start {}" , requestModel.getSampleKey());
        log.info("[SampleService.patchSample] end {}" , requestModel);
        return PatchSampleModel.Response.builder()
                .phoneNumber("010-0000-0000")
                .email("save7412@naver.com")
                .noWhitespace("noWhitespace")
                .integerBody(5)
                .numberBody(3.0)
                .stringBody("stringBody")
                .booleanBody(true)
                .arrayBody(new ArrayList<>(Arrays.asList(
                        "고","기","가","가","가","기","고"
                )))
                .build();
    }

    public PutSampleModel.Response putSample(PutSampleModel.Request requestModel , PutSampleModel.RequestBody requestBody) {
        log.info("[SampleService.putSample] start {}" , requestModel.getSampleKey());
        log.info("[SampleService.putSample] end {}" , requestModel);
        return PutSampleModel.Response.builder()
                .phoneNumber("010-0000-0000")
                .email("save7412@naver.com")
                .noWhitespace("noWhitespace")
                .integerBody(5)
                .numberBody(3.0)
                .stringBody("stringBody")
                .booleanBody(true)
                .arrayBody(new ArrayList<>(Arrays.asList(
                        "고","기","가","가","가","기","고"
                )))
                .build();
    }


    public void deleteSample(DeleteSampleModel.Request requestModel) {
        log.info("[SampleService.deleteSample] start {}" , requestModel.getSampleKey());
        log.info("[SampleService.deleteSample] end {}" , requestModel);
    }
}
