package com.creawor.sales.business.task;

import com.creawor.sales.model.SalesTask;
import com.creawor.sales.model.vo.TaskDetailVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Zero on 2017/3/10.
 *
 */
public interface TaskRepo extends JpaRepository<SalesTask, String>, JpaSpecificationExecutor<SalesTask> {

}
