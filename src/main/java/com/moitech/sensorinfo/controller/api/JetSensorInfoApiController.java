package com.moitech.sensorinfo.controller.api;

import com.moitech.sensorinfo.domain.JetAuthTestHistory;
import com.moitech.sensorinfo.domain.JetSensorInfo;
import com.moitech.sensorinfo.response.ListResult;
import com.moitech.sensorinfo.response.SingleResult;
import com.moitech.sensorinfo.service.JetSensorInfoService;
import com.moitech.sensorinfo.service.ResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = {". JetSensorInfo"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")

public class JetSensorInfoApiController {
    private final JetSensorInfoService jetSensorInfoService;
    private final ResultService resultService;

    @ApiOperation(value = "노드 아이디로 센서 정보 조회", notes = "노드 아이디에 해당 센서 정보를 조회한다")
    @GetMapping(value = "/JetSensorInfo/{nodeId}")
    public SingleResult<JetSensorInfo> findJetSensorInfo(@RequestParam String nodeId){
        return resultService.getSingleResult(jetSensorInfoService.findByNodeId(nodeId));
    }
}
