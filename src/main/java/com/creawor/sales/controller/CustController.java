package com.creawor.sales.controller;

import com.creawor.sales.annotation.CurrentUser;
import com.creawor.sales.annotation.LoginRequired;
import com.creawor.sales.business.cust.CustService;
import com.creawor.sales.business.task.TaskService;
import com.creawor.sales.common.PageInfo;
import com.creawor.sales.common.RestResult;
import com.creawor.sales.common.RestResultGenerator;
import com.creawor.sales.model.Customer;
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
@RestController(value = "/api/cust")
@RequestMapping("/api/cust")
public class CustController {
    @Autowired
    private CustService custService;

    @Bean
    public CustService getCustService() {
        return new CustService();
    }

    @LoginRequired
    @RequestMapping("all")
    public RestResult<PageInfo<Customer>> getTask(@RequestParam("page") int page,
                                                  @RequestParam("pageSize") int pageSize,
                                                  @RequestParam("executeId") String execId,
                                                  @CurrentUser User currUser) {
        PageInfo<Customer> result = new PageInfo<>();
        Sort sort = new Sort(Sort.Direction.DESC, "uid");
        PageRequest pageRequest = new PageRequest(page, pageSize, sort);
        Page<Customer> pageRows = custService.findAll(pageRequest, execId);
        result.setCount((int) pageRows.getTotalElements());
        result.setRows(pageRows.getContent());
        return RestResultGenerator.genSuccessResult(result);
    }
}
