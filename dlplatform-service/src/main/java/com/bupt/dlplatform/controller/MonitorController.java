package com.bupt.dlplatform.controller;

import com.bupt.dlplatform.service.DataDisplayService;
import com.bupt.dlplatform.service.MonitorService;
import com.bupt.dlplatform.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by huhx on 2020/10/3
 */
@RestController
@RequestMapping("/dlplatform/monitor")
public class MonitorController {
    @Autowired
    private MonitorService monitorService;

    /*
     * 新建监控
     */
    @PostMapping("/create")
    public ResponseVO createMMonitorEntity(@RequestBody MMonitorEntityInputVO request){
        return monitorService.createMMonitorEntity(request);
    }

    /**
     * 更新监控
     */
    @PostMapping("/update")
    public ResponseVO updateMMonitorEntity(@RequestBody MMonitorEntityInputVO request){
        return monitorService.updateMMonitorEntity(request);
    }

    /*
     * 读取一条监控（Id方式）
     */
    @GetMapping("/getById")
    public ResponseVO<MMonitorEntityOutputVO> getMonitor(@RequestParam(value = "id") String id){
        return monitorService.getMMonitorEntityById(id);
    }

    /**
     * 删除监控
     */
    @DeleteMapping("/delete")
    public ResponseVO deleteMMonitorEntity(@RequestParam(value = "id") String id){
        return monitorService.deleteMMonitorEntity(id);
    }
}
