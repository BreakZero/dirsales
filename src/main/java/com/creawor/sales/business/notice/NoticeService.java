package com.creawor.sales.business.notice;

import com.creawor.sales.model.NoticeInfo;
import com.creawor.sales.model.SalesTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zero on 2017/3/10.
 * 客户Service层
 */
@Service
public class NoticeService implements INoticeService {

    @Autowired
    private NoticeRepo mNoticeRepo;

    @Override
    public NoticeInfo save(NoticeInfo entity) throws Exception {
        return mNoticeRepo.save(entity);
    }

    @Override
    public void delete(String id) throws Exception {
        mNoticeRepo.delete(id);
    }

    @Override
    public void delete(NoticeInfo entity) throws Exception {
        mNoticeRepo.delete(entity);
    }

    @Override
    public NoticeInfo findById(String id) {
        return mNoticeRepo.findOne(id);
    }

    @Override
    public NoticeInfo findBySample(NoticeInfo sample) {
        return mNoticeRepo.findOne(sample.getUid());
    }

    @Override
    public List<NoticeInfo> findAll() {
        return mNoticeRepo.findAll();
    }

    @Override
    public Page<NoticeInfo> findAll(PageRequest pageRequest) {
        return mNoticeRepo.findAll(pageRequest);
    }

    @Override
    public Page<NoticeInfo> findAll(Pageable pageable, String type) {
        return mNoticeRepo.findAll(whereSpec(type), pageable);
    }

    /**
     * 根据分类查询
     * @param type 分类ID
     * @return 结果
     */
    private Specification<NoticeInfo> whereSpec(String type) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            Path<String> statePath = root.get("classId");
            if (!StringUtils.isEmpty(type)) {
                predicates.add(cb.equal(statePath, type));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
