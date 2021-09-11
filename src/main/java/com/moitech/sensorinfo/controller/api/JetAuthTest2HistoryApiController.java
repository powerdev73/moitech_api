package com.moitech.sensorinfo.controller.api;

import com.moitech.sensorinfo.domain.JetAuthTest2History;
import com.moitech.sensorinfo.domain.JetAuthTestHistory;
import com.moitech.sensorinfo.response.ListResult;
import com.moitech.sensorinfo.service.JetAuthTest2HistoryService;
import com.moitech.sensorinfo.service.ResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"4. JetAuthTest2History"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class JetAuthTest2HistoryApiController {
    private final JetAuthTest2HistoryService jetAuthTest2HistoryService;
    private final ResultService resultService;

    @ApiOperation(value = "현재 시간 이후 히스토리 정보 리스트 조회", notes = "현재 시간 이후 히스토리 정보 리스트를 조회한다")
    @GetMapping(value = "/JetAuthTest2History/{nowDate}")
    public ListResult<JetAuthTest2History> findJetAuthTestHistoryByUpdateNow(@RequestParam String nowDate){
        return resultService.getListResult(jetAuthTest2HistoryService.findByUpdateNow(nowDate));
    }
}
