package com.creawor.sales.controller;

import com.creawor.sales.business.notice.NoticeService;
import com.creawor.sales.business.notice.NoticeTypeService;
import com.creawor.sales.common.PageInfo;
import com.creawor.sales.common.RestResult;
import com.creawor.sales.common.RestResultGenerator;
import com.creawor.sales.model.NoticeInfo;
import com.creawor.sales.model.NoticeType;
import com.creawor.sales.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zero on 2017/3/10.
 * 营销客户相关Controller
 */
@RestController(value = "/api/notice")
@RequestMapping("/api/notice")
public class NoticeController {

    @Autowired
    private NoticeService mNoticeService;

    @Autowired
    private NoticeTypeService mNoticeTypeService;

    @Bean
    public NoticeService getNoticeService() {
        return new NoticeService();
    }

    @Bean
    public NoticeTypeService getNoticeTypeService() {
        return new NoticeTypeService();
    }

    @RequestMapping("all")
    public RestResult<PageInfo<NoticeInfo>> getNotice(@RequestParam("page") int page,
                                                      @RequestParam("pageSize") int pageSize,
                                                      @RequestParam("type") String type) {
        PageInfo<NoticeInfo> result = new PageInfo<>();
        Sort sort = new Sort(Sort.Direction.DESC, "uid");
        PageRequest pageRequest = new PageRequest(page, pageSize, sort);
        Page<NoticeInfo> pageRows = mNoticeService.findAll(pageRequest, type);

        result.setCount((int) pageRows.getTotalElements());
        result.setRows(pageRows.getContent());
        return RestResultGenerator.genSuccessResult(result);
    }

    @RequestMapping(value = "type", method = RequestMethod.GET)
    public RestResult<List<NoticeType>> getNoticeType() {
        List<NoticeType> result = mNoticeTypeService.findAll();
        return RestResultGenerator.genSuccessResult(result);
    }
}
