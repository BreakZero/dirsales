package com.creawor.sales.business.know.file;

import com.creawor.sales.model.KnowledgeFile;
import com.creawor.sales.model.KnowledgeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Zero on 2017/3/10.
 * 知识库文件Dao层
 */
interface KnowFileRepo extends JpaRepository<KnowledgeFile, String>, JpaSpecificationExecutor<KnowledgeFile> {
    @Query("select count(0) from KnowledgeFile know where know.typeId = :type" )
    int findCount(@Param("type") String type);
}
