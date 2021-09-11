package com.moitech.sensorinfo.controller.api;

import com.moitech.sensorinfo.domain.JetAuthTest2History;
import com.moitech.sensorinfo.domain.JetAuthTest5History;
import com.moitech.sensorinfo.response.ListResult;
import com.moitech.sensorinfo.service.JetAuthTest5HistoryService;
import com.moitech.sensorinfo.service.ResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"5. JetAuthTest5History"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class JetAuthTest5HistoryApiController {
    private final JetAuthTest5HistoryService jetAuthTest5HistoryService;
    private final ResultService resultService;

    @ApiOperation(value = "현재 시간 이후 히스토리 정보 리스트 조회", notes = "현재 시간 이후 히스토리 정보 리스트를 조회한다")
    @GetMapping(value = "/JetAuthTest5History/{nowDate}")
    public ListResult<JetAuthTest5History> findJetAuthTestHistoryByUpdateNow(@RequestParam String nowDate){
        return resultService.getListResult(jetAuthTest5HistoryService.findByUpdateNow(nowDate));
    }
}
