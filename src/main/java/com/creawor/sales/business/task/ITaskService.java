package com.creawor.sales.business.task;

import com.creawor.sales.common.ICommonService;
import com.creawor.sales.model.SalesTask;
import com.creawor.sales.model.vo.TaskDetailVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * Created by Zero on 2017/3/10.
 * 面向接口接口定义
 */
public interface ITaskService extends ICommonService<SalesTask> {
    Page<SalesTask> findAll(Pageable pageable, String state);
    Page<SalesTask> findSignTask(Pageable pageable, String jobNumber, String taskName);
    void signTask(String excuId, int state) throws Exception;
}
