package com.creawor.sales.business.rank;

import com.creawor.sales.model.NoticeInfo;
import com.creawor.sales.model.TaskRankInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zero on 2017/4/26.
 *
 */
public class TaskRankService implements IRankService {

    @Autowired
    private TaskRankRepo mRankRepo;

    @Override
    public TaskRankInfo save(TaskRankInfo entity) throws Exception {
        return mRankRepo.save(entity);
    }

    @Override
    public void delete(String id) throws Exception {
        mRankRepo.delete(id);
    }

    @Override
    public void delete(TaskRankInfo entity) throws Exception {
        mRankRepo.delete(entity);
    }

    @Override
    public TaskRankInfo findById(String id) {
        return mRankRepo.findOne(id);
    }

    @Override
    public TaskRankInfo findBySample(TaskRankInfo sample) {
        return mRankRepo.findOne(sample.getActId());
    }

    @Override
    public List<TaskRankInfo> findAll() {
        return mRankRepo.findAll();
    }

    @Override
    public Page<TaskRankInfo> findAll(PageRequest pageRequest) {
        return mRankRepo.findAll(pageRequest);
    }

    @Override
    public TaskRankInfo findOne(String phone, String actId) {
        return mRankRepo.findOne(whereSpec(phone, actId));
    }

    private Specification<TaskRankInfo> whereSpec(String phone, String actId) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            Path<String> phonePath = root.get("managerNumber");
            Path<String> actIdPath = root.get("actId");
            if (!StringUtils.isEmpty(phone)) {
                predicates.add(cb.equal(phonePath, phone));
            }
            if (!StringUtils.isEmpty(actId)) {
                predicates.add(cb.equal(actIdPath, actId));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
