package com.creawor.sales.business.cust;

import com.creawor.sales.business.task.ITaskService;
import com.creawor.sales.business.task.TaskRepo;
import com.creawor.sales.model.Customer;
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
public class CustService implements ICustService {

    @Autowired
    private CustRepo taskRepo;

    @Override
    public Customer save(Customer entity) throws Exception {
        return taskRepo.save(entity);
    }

    @Override
    public void delete(String id) throws Exception {
        taskRepo.delete(id);
    }

    @Override
    public void delete(Customer entity) throws Exception {
        taskRepo.delete(entity);
    }

    @Override
    public Customer findById(String id) {
        return taskRepo.findOne(id);
    }

    @Override
    public Customer findBySample(Customer sample) {
        return taskRepo.findOne(sample.getUid());
    }

    @Override
    public List<Customer> findAll() {
        return taskRepo.findAll();
    }

    @Override
    public Page<Customer> findAll(PageRequest pageRequest) {
        return taskRepo.findAll(pageRequest);
    }
}
