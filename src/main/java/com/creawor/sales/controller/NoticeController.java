package com.creawor.sales.controller;

import com.creawor.sales.business.notice.NoticeService;
import com.creawor.sales.common.PageInfo;
import com.creawor.sales.common.RestResult;
import com.creawor.sales.common.RestResultGenerator;
import com.creawor.sales.model.NoticeInfo;
import com.creawor.sales.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Zero on 2017/3/10.
 * 营销客户相关Controller
 */
@RestController(value = "/api/notice")
@RequestMapping("/api/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @Bean
    public NoticeService getNoticeService() {
        return new NoticeService();
    }

    @RequestMapping("all")
    public RestResult<PageInfo<NoticeInfo>> getTask(@RequestParam("page") int page,
                                                    @RequestParam("pageSize") int pageSize) {
        PageInfo<NoticeInfo> result = new PageInfo<>();
        Sort sort = new Sort(Sort.Direction.DESC, "uid");
        PageRequest pageRequest = new PageRequest(page, pageSize, sort);
        Page<NoticeInfo> pageRows = noticeService.findAll(pageRequest);
        result.setCount((int) pageRows.getTotalElements());
        result.setRows(pageRows.getContent());
        return RestResultGenerator.genSuccessResult(result);
    }
}
