package com.creawor.sales.controller;

import com.creawor.sales.annotation.CurrentUser;
import com.creawor.sales.annotation.LoginRequired;
import com.creawor.sales.business.cust.CustService;
import com.creawor.sales.business.rank.TaskRankService;
import com.creawor.sales.business.task.TaskService;
import com.creawor.sales.common.PageInfo;
import com.creawor.sales.common.RestResult;
import com.creawor.sales.common.RestResultGenerator;
import com.creawor.sales.model.SalesTask;
import com.creawor.sales.model.TaskRankInfo;
import com.creawor.sales.model.User;
import com.creawor.sales.model.vo.SignTaskVo;
import com.creawor.sales.model.vo.TaskDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zero on 2017/3/10.
 * 任务相关Controller
 */
@RestController(value = "/api/task")
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private CustService custService;

    @Autowired
    private TaskRankService taskRankService;

    @Bean
    public TaskRankService getTaskRankService() {
        return new TaskRankService();
    }

    @Bean
    public TaskService getTaskService() {
        return new TaskService();
    }

    @LoginRequired
    @RequestMapping("all")
    public RestResult<PageInfo<TaskDetailVo>> getTask(@RequestParam("page") int page,
                                                      @RequestParam("pageSize") int pageSize,
                                                      @RequestParam("state") String state,
                                                      @CurrentUser User currUser) {
        PageInfo<TaskDetailVo> result = new PageInfo<>();
        Sort sort = new Sort(Sort.Direction.DESC, "uid");
        PageRequest pageRequest = new PageRequest(page, pageSize, sort);
        Page<SalesTask> pageRows;

        if ("0".equals(state)) {
            pageRows = taskService.findAll(pageRequest);
        } else {
            pageRows = taskService.findAll(pageRequest, state);
        }

        result.setCount((int) pageRows.getTotalElements());

        List<SalesTask> rows = pageRows.getContent();
        List<TaskDetailVo> details = new ArrayList<>();
        for (SalesTask task : rows) {
            TaskDetailVo row = new TaskDetailVo();
            row.setActivityId(task.getTaskDetail().getActivityId());
            row.setActivityName(task.getTaskDetail().getActivityName());
            row.setSignState(task.getSignState());
            row.setPhoneNum(task.getJobNumber());
            row.setMarketTerms(task.getTaskDetail().getMarketTerms());
            row.setUid(task.getUid());
            row.setStarNum(task.getTaskDetail().getStarNum());
            details.add(row);
        }

        result.setRows(details);
        return RestResultGenerator.genSuccessResult(result);
    }

    @RequestMapping("signOrRefuse")
    public RestResult<Integer> signOrRefuseTask(@RequestParam("excuId") String excuId,
                                                @RequestParam("state") int state) {
        taskService.signTask(excuId, state);
        return RestResultGenerator.genSuccessResult(state);
    }

    @LoginRequired
    @RequestMapping("signTask")
    public RestResult<PageInfo<SignTaskVo>> getSignTask(@RequestParam("page") int page,
                                                        @RequestParam("pageSize") int pageSize,
                                                        @RequestParam("taskName") String taskName,
                                                        @CurrentUser User currUser) {
        PageInfo<SignTaskVo> result = new PageInfo<>();
        Sort sort = new Sort(Sort.Direction.DESC, "uid");
        PageRequest pageRequest = new PageRequest(page, pageSize, sort);
        Page<SalesTask> pageRows = taskService.findSignTask(pageRequest, currUser.getJobNumber(), taskName);
        result.setCount((int) pageRows.getTotalElements());

        List<SalesTask> rows = pageRows.getContent();
        List<SignTaskVo> data = new ArrayList<>();
        for (SalesTask task : rows) {
            SignTaskVo row = new SignTaskVo();
            row.setTaskName(task.getTaskDetail().getActivityName());
            row.setTotal(custService.getCount(task.getUid()));
            row.setMarketCount(custService.getMarketCount(task.getUid()));
            row.setOrderCount(custService.getOrderCount(task.getUid()));
            data.add(row);
        }
        result.setRows(data);
        return RestResultGenerator.genSuccessResult(result);
    }

    @RequestMapping("getRank")
    public RestResult<TaskRankInfo> getTaskRank(@RequestParam("phone") String phone,
                                                @RequestParam("actId") String actId) {
        TaskRankInfo info = taskRankService.findOne(phone, actId);
        return null == info ? RestResultGenerator.genErrorResult("找不到任务排行信息")
                : RestResultGenerator.genSuccessResult(info);
    }
}
