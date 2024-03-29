package com.liwell.cinema.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liwell.cinema.domain.dto.CollectTaskAddDTO;
import com.liwell.cinema.domain.dto.CollectTaskPageDTO;
import com.liwell.cinema.domain.dto.IdDTO;
import com.liwell.cinema.domain.enums.CollectTaskStateEnum;
import com.liwell.cinema.domain.po.Result;
import com.liwell.cinema.domain.vo.CollectTaskPageVO;
import com.liwell.cinema.service.CollectTaskService;
import com.liwell.cinema.util.EnumUtils;
import com.liwell.cinema.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @author: litianyi
 * @date: Created on 2023/02/03
 */
@RestController
@RequestMapping("/collectTask")
public class CollectTaskController {

    @Autowired
    private CollectTaskService collectTaskService;

    /**
     * 采集任务列表
     * @param dto
     * @return
     */
    @PostMapping("/pageCollectTask")
    public Result<Page<CollectTaskPageVO>> pageCollectTask(@RequestBody CollectTaskPageDTO dto) {
        return ResultUtil.success(collectTaskService.pageCollectTask(dto));
    }

    /**
     * 新增任务
     * @param dto
     * @return
     */
    @PostMapping("/addCollectTask")
    public Result addCollectTask(@RequestBody CollectTaskAddDTO dto) {
        return ResultUtil.trueOrFalse(collectTaskService.addCollectTask(dto));
    }

    /**
     * 开始任务
     * @param dto
     * @return
     */
    @PostMapping("/startCollectTask")
    public Result startCollectTask(@RequestBody IdDTO dto) {
        return ResultUtil.trueOrFalse(collectTaskService.startCollectTask(dto));
    }

    /**
     * 暂停任务
     * @param idDTO
     * @return
     */
    @PostMapping("/pauseCollectTask")
    public Result pauseCollectTask(@RequestBody IdDTO idDTO) {
        return ResultUtil.trueOrFalse(collectTaskService.pauseCollectTask(idDTO.getId()));
    }

    /**
     * 停止任务
     * @param idDTO
     * @return
     */
    @PostMapping("/stopCollectTask")
    public Result stopCollectTask(@RequestBody IdDTO idDTO) {
        return ResultUtil.trueOrFalse(collectTaskService.stopCollectTask(idDTO.getId()));
    }

    /**
     * 查询任务采集进度
     * @param idDTO
     * @return
     */
    @PostMapping("/getTaskProcess")
    public Result<Integer> getTaskProcess(@RequestBody IdDTO idDTO) {
        return ResultUtil.success(collectTaskService.getTaskProcess(idDTO.getId()));
    }

    /**
     * 查询任务状态列表
     * @return
     */
    @PostMapping("/listCollectTaskState")
    public Result<List<CollectTaskStateEnum>> listCollectTaskState() {
        return ResultUtil.success(EnumUtils.listEnums(CollectTaskStateEnum.class));
    }

}