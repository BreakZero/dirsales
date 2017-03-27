package com.creawor.sales.business.task;

import com.creawor.sales.model.SalesTask;
import com.creawor.sales.model.vo.TaskDetailVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Zero on 2017/3/10.
 *
 */
public interface TaskRepo extends JpaRepository<SalesTask, String>, JpaSpecificationExecutor<SalesTask> {
    @Modifying
    @Query("update SalesTaskDetail detail set detail.actState = :state where " +
            "detail.activityId = (select task.taskDetail.activityId from SalesTask" +
            " task where task.uid = :excuId)")
    void signTask(@Param("excuId") String excuId, @Param("state") String state);
}
