package com.creawor.sales.controller;

import com.creawor.sales.annotation.CurrentUser;
import com.creawor.sales.annotation.LoginRequired;
import com.creawor.sales.business.task.TaskService;
import com.creawor.sales.common.PageInfo;
import com.creawor.sales.common.RestResult;
import com.creawor.sales.common.RestResultGenerator;
import com.creawor.sales.model.SalesTask;
import com.creawor.sales.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zero on 2017/3/10.
 * 任务相关Controller
 */
@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Bean
    public TaskService getTaskService() {
        return new TaskService();
    }

    @LoginRequired
    @RequestMapping("all")
    public RestResult<PageInfo<SalesTask>> getTask(@RequestParam("page") int page,
                                                  @RequestParam("pageSize") int pageSize,
                                                  @CurrentUser User currUser) {
        PageInfo<SalesTask> result = new PageInfo<>();
        Sort sort = new Sort(Sort.Direction.DESC, "executeId");
        PageRequest pageRequest = new PageRequest(page, pageSize, sort);
        Page<SalesTask> pageRows = taskService.findAll(pageRequest);
        result.setCount((int) pageRows.getTotalElements());
        result.setRows(pageRows.getContent());
        return RestResultGenerator.genSuccessResult(result);
    }
}
