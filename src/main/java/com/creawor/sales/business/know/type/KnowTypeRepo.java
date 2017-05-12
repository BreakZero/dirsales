package com.creawor.sales.business.know.type;

import com.creawor.sales.model.KnowledgeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Zero on 2017/3/10.
 * 知识库类型Dao层
 */
public interface KnowTypeRepo extends JpaRepository<KnowledgeType, String>, JpaSpecificationExecutor<KnowledgeType> {

}
