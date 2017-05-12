package com.creawor.sales.business.know.file;

import com.creawor.sales.common.ICommonService;
import com.creawor.sales.model.KnowledgeFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Zero on 2017/3/10.
 * 面向接口接口定义--知识库文件模块
 */
interface IFileService extends ICommonService<KnowledgeFile> {
    Page<KnowledgeFile> findAll(Pageable pageable, String type);
    int findCountByType(String type);
}
