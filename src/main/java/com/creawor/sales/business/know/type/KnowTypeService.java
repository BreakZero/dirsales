package com.creawor.sales.business.know.type;

import com.creawor.sales.model.KnowledgeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created by Zero on 2017/4/26.
 *
 */
public class KnowTypeService implements ITypeService {

    @Autowired
    private KnowTypeRepo mKnowTypeRepo;


    @Override
    public KnowledgeType save(KnowledgeType entity) throws Exception {
        return mKnowTypeRepo.save(entity);
    }

    @Override
    public void delete(String id) throws Exception {
        mKnowTypeRepo.delete(id);
    }

    @Override
    public void delete(KnowledgeType entity) throws Exception {
        mKnowTypeRepo.delete(entity);
    }

    @Override
    public KnowledgeType findById(String id) {
        return mKnowTypeRepo.findOne(id);
    }

    @Override
    public KnowledgeType findBySample(KnowledgeType sample) {
        return mKnowTypeRepo.findOne(sample.getUid());
    }

    @Override
    public List<KnowledgeType> findAll() {
        return mKnowTypeRepo.findAll();
    }

    @Override
    public Page<KnowledgeType> findAll(PageRequest pageRequest) {
        return mKnowTypeRepo.findAll(pageRequest);
    }
}
