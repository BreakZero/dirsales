package com.creawor.sales.business.task;

import com.creawor.sales.model.SalesTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Zero on 2017/3/10.
 *
 */
public interface TaskRepo extends JpaRepository<SalesTask, String>, JpaSpecificationExecutor<SalesTask> {

}
