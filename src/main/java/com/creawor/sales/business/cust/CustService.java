package com.creawor.sales.business.cust;

import com.creawor.sales.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zero on 2017/3/10.
 * 客户Service层
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

    @Override
    public Page<Customer> findAll(Pageable pageable, String excuId) {
        return taskRepo.findAll(whereSpec(excuId), pageable);
    }

    @Override
    public int getCount(String excuId) {
        return taskRepo.getCount(excuId);
    }

    @Override
    public int getMarketCount(String excuId) {
        return taskRepo.getMarketCount(excuId);
    }

    @Override
    public int getOrderCount(String excuId) {
        return taskRepo.getOrderCount(excuId);
    }

    private Specification<Customer> whereSpec(String excuId) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            Path<String> statePath = root.get("executeId");
            if (null != excuId) {
                predicates.add(cb.equal(statePath, excuId));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
