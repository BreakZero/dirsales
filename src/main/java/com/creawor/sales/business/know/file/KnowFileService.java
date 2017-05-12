package com.creawor.sales.business.know.file;

import com.creawor.sales.model.KnowledgeFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zero on 2017/4/26.
 * 知识库文件Service层
 */
public class KnowFileService implements IFileService {

    @Autowired
    private KnowFileRepo mKnowFileRepo;


    @Override
    public KnowledgeFile save(KnowledgeFile entity) throws Exception {
        return mKnowFileRepo.save(entity);
    }

    @Override
    public void delete(String id) throws Exception {
        mKnowFileRepo.delete(id);
    }

    @Override
    public void delete(KnowledgeFile entity) throws Exception {
        mKnowFileRepo.delete(entity);
    }

    @Override
    public KnowledgeFile findById(String id) {
        return mKnowFileRepo.findOne(id);
    }

    @Override
    public KnowledgeFile findBySample(KnowledgeFile sample) {
        return mKnowFileRepo.findOne(sample.getUid());
    }

    @Override
    public List<KnowledgeFile> findAll() {
        return mKnowFileRepo.findAll();
    }

    @Override
    public Page<KnowledgeFile> findAll(PageRequest pageRequest) {
        return mKnowFileRepo.findAll(pageRequest);
    }

    @Override
    public Page<KnowledgeFile> findAll(Pageable pageable, String type) {
        return mKnowFileRepo.findAll(whereSpec(type), pageable);
    }

    @Override
    public int findCountByType(String type) {
        return mKnowFileRepo.findCount(type);
    }


    /**
     * 根据分类查询
     *
     * @param type 分类ID
     * @return 结果
     */
    private Specification<KnowledgeFile> whereSpec(String type) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            Path<String> statePath = root.get("typeId");
            if (!StringUtils.isEmpty(type)) {
                predicates.add(cb.equal(statePath, type));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
