package com.creawor.sales.business.task;

import com.creawor.sales.model.SalesTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zero on 2017/3/10.
 *
 */
@Service
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Override
    public SalesTask save(SalesTask entity) throws Exception {
        return taskRepo.save(entity);
    }

    @Override
    public void delete(String id) throws Exception {
        taskRepo.delete(id);
    }

    @Override
    public void delete(SalesTask entity) throws Exception {
        taskRepo.delete(entity);
    }

    @Override
    public SalesTask findById(String id) {
        return taskRepo.findOne(id);
    }

    @Override
    public SalesTask findBySample(SalesTask sample) {
        return taskRepo.findOne(sample.getExecuteId());
    }

    @Override
    public List<SalesTask> findAll() {
        return taskRepo.findAll();
    }

    @Override
    public Page<SalesTask> findAll(PageRequest pageRequest) {
        return taskRepo.findAll(pageRequest);
    }
}
