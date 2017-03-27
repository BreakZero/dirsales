package com.creawor.sales.business.task;

import com.creawor.sales.model.SalesTask;
import com.creawor.sales.model.SalesTaskDetail;
import com.creawor.sales.model.User;
import com.creawor.sales.model.vo.TaskDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
        return taskRepo.findOne(sample.getUid());
    }

    @Override
    public List<SalesTask> findAll() {
        return taskRepo.findAll();
    }

    @Override
    public Page<SalesTask> findAll(PageRequest pageRequest) {
        return taskRepo.findAll(pageRequest);
    }

    @Override
    public Page<SalesTask> findAll(Pageable pageable, String state) {
        return taskRepo.findAll(whereSpec(state), pageable);
    }

    @Transactional
    @Override
    public void signTask(String excuId, String state) {
        taskRepo.signTask(excuId, state);
    }

    private Specification<SalesTask> whereSpec(String state) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            Path<String> statePath = root.get("taskDetail").get("actState");
            if (null != state) {
                predicates.add(cb.equal(statePath, state));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

}
