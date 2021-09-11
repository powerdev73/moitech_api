package com.moitech.sensorinfo.controller.api;

import com.moitech.sensorinfo.domain.JetAuthTestHistory;
import com.moitech.sensorinfo.domain.JetSensorHistory;
import com.moitech.sensorinfo.response.ListResult;
import com.moitech.sensorinfo.service.JetAuthTestHistoryService;
import com.moitech.sensorinfo.service.JetSensorHistoryService;
import com.moitech.sensorinfo.service.ResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(tags = {"3. JetSensorHistory"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class JetSeosorHistoryApiController {
    private final JetSensorHistoryService jetSensorHistoryService;
    private final ResultService resultService;

    @ApiOperation(value = "센서 히스토리 정보 리스트 조회", notes = "모든 센서 히스토리 정보 리스트를 조회한다")
    @GetMapping(value = "/JetSensorHistory")
    public ListResult<JetSensorHistory> findSensorHistories(){
        return resultService.getListResult(jetSensorHistoryService.findAll());
    }

    @ApiOperation(value = "현재 시간 이후 히스토리 정보 리스트 조회", notes = "현재 시간 이후 히스토리 정보 리스트를 조회한다")
    @GetMapping(value = "/JetSensorHistory/{nowDate}")
    public ListResult<JetSensorHistory> findJetAuthTestHistoryByUpdateNow(@RequestParam String nowDate){
        return resultService.getListResult(jetSensorHistoryService.findByUpdateNow(nowDate));
    }
}
