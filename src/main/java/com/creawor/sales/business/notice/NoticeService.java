package com.creawor.sales.business.notice;

import com.creawor.sales.model.NoticeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
}
