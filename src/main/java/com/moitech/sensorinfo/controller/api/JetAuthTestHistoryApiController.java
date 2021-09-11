package com.moitech.sensorinfo.controller.api;

import com.moitech.sensorinfo.domain.JetAuthTestHistory;
import com.moitech.sensorinfo.response.ListResult;
import com.moitech.sensorinfo.service.JetAuthTestHistoryService;
import com.moitech.sensorinfo.service.ResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Api(tags = {"1. JetAuthTestHistory"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class JetAuthTestHistoryApiController {
    private final JetAuthTestHistoryService jetAuthTestHistoryService;
    private final ResultService resultService;

    @ApiOperation(value = "히스토리 정보 리스트 조회", notes = "모든 히스토리 정보 리스트를 조회한다")
    @GetMapping(value = "/JetAuthTestHistory")
    public ListResult<JetAuthTestHistory> findJetAuthTestHistories(){
        return resultService.getListResult(jetAuthTestHistoryService.findAll());
    }

    @ApiOperation(value = "현재 시간 이후 히스토리 정보 리스트 조회", notes = "현재 시간 이후 히스토리 정보 리스트를 조회한다")
    @GetMapping(value = "/JetAuthTestHistory/{nowDate}")
    public ListResult<JetAuthTestHistory> findJetAuthTestHistoryByUpdateNow(@RequestParam String nowDate){
        return resultService.getListResult(jetAuthTestHistoryService.findByUpdateNow(nowDate));
    }
}
