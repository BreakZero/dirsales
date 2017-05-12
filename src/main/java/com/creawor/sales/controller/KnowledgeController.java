package com.creawor.sales.controller;

import com.creawor.sales.business.know.file.KnowFileService;
import com.creawor.sales.business.know.type.KnowTypeService;
import com.creawor.sales.business.notice.NoticeService;
import com.creawor.sales.business.notice.NoticeTypeService;
import com.creawor.sales.common.PageInfo;
import com.creawor.sales.common.RestResult;
import com.creawor.sales.common.RestResultGenerator;
import com.creawor.sales.model.KnowledgeFile;
import com.creawor.sales.model.KnowledgeType;
import com.creawor.sales.model.NoticeInfo;
import com.creawor.sales.model.NoticeType;
import com.creawor.sales.model.vo.KnowledgeTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zero on 2017/3/10.
 * 营销客户相关Controller
 */
@RestController(value = "/api/know")
@RequestMapping("/api/know")
public class KnowledgeController {

    @Autowired
    private KnowTypeService mKnowTypeService;

    @Autowired
    private KnowFileService mKnowFileService;

    @Bean
    public KnowTypeService getKnowTypeService() {
        return new KnowTypeService();
    }

    @Bean
    public KnowFileService getKnowFileService() {
        return new KnowFileService();
    }

    @RequestMapping(value = "/type/all", method = RequestMethod.GET)
    public RestResult<List<KnowledgeTypeVo>> getKnowledgeTypes() {
        List<KnowledgeType> rows = mKnowTypeService.findAll();
        List<KnowledgeTypeVo> result = new ArrayList<>();
        for (KnowledgeType row : rows) {
            KnowledgeTypeVo vo = new KnowledgeTypeVo();
            vo.setUid(row.getUid());
            vo.setTypeDescribe(row.getTypeDescribe());
            vo.setTypeName(row.getTypeName());
            vo.setFileCount(mKnowFileService.findCountByType(row.getUid()));
            result.add(vo);
        }
        return RestResultGenerator.genSuccessResult(result);
    }

    @RequestMapping(value = "/file/all", method = RequestMethod.POST)
    public RestResult<PageInfo<KnowledgeFile>> getKnowledgeFiles(@RequestParam("page") int page,
                                                                 @RequestParam("pageSize") int pageSize,
                                                                 @RequestParam("type") String type) {
        PageInfo<KnowledgeFile> result = new PageInfo<>();
        Sort sort = new Sort(Sort.Direction.DESC, "uid");
        PageRequest pageRequest = new PageRequest(page, pageSize, sort);
        Page<KnowledgeFile> pageRows = mKnowFileService.findAll(pageRequest, type);

        result.setCount((int) pageRows.getTotalElements());
        result.setRows(pageRows.getContent());
        return RestResultGenerator.genSuccessResult(result);
    }
}
