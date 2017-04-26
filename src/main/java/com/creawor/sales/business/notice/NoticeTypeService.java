package com.creawor.sales.business.notice;

import com.creawor.sales.model.NoticeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created by Zero on 2017/4/26.
 *
 */
public class NoticeTypeService implements INoticeTypeService {

    @Autowired
    private NoticeTypeRepo mNoticeTypeRepo;

    @Override
    public NoticeType save(NoticeType entity) throws Exception {
        return mNoticeTypeRepo.save(entity);
    }

    @Override
    public void delete(String id) throws Exception {
        mNoticeTypeRepo.delete(id);
    }

    @Override
    public void delete(NoticeType entity) throws Exception {
        mNoticeTypeRepo.delete(entity);
    }

    @Override
    public NoticeType findById(String id) {
        return mNoticeTypeRepo.findOne(id);
    }

    @Override
    public NoticeType findBySample(NoticeType sample) {
        return mNoticeTypeRepo.findOne(sample.getUid());
    }

    @Override
    public List<NoticeType> findAll() {
        return mNoticeTypeRepo.findAll();
    }

    @Override
    public Page<NoticeType> findAll(PageRequest pageRequest) {
        return mNoticeTypeRepo.findAll(pageRequest);
    }
}
