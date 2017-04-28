package com.creawor.sales.business.rank;

import com.creawor.sales.model.TaskRankInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Zero on 2017/3/10.
 * 任务排行Dao层
 */
interface TaskRankRepo extends JpaRepository<TaskRankInfo, String>, JpaSpecificationExecutor<TaskRankInfo> {

}
