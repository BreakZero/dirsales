package com.creawor.sales.business.user;

import com.creawor.sales.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jin_ on 2016/11/10.
 *
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User save(User entity) throws Exception {
        return userRepo.save(entity);
    }

    @Override
    public void delete(String id) throws Exception {
        userRepo.delete(id);
    }

    @Override
    public void delete(User entity) throws Exception {
        userRepo.delete(entity);
    }

    @Override
    public User findById(String id) {
        return userRepo.findOne(id);
    }

    @Override
    public User findBySample(User sample) {
        return userRepo.findOne(whereSpec(sample));
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Page<User> findAll(PageRequest pageRequest) {
        return userRepo.findAll(pageRequest);
    }

    @Override
    public User findOne(String account, String password) {
        return userRepo.findOne(whereSpec(account, password));
    }

    private Specification<User> whereSpec(final User sample) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (null != sample.getUserId()) {
                predicates.add(cb.equal(root.<String>get("userId"), sample.getUserId()));
            }

            if (StringUtils.hasLength(sample.getAccountNo())) {
                predicates.add(cb.equal(root.get("accountNo"), sample.getAccountNo()));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    private Specification<User> whereSpec(String account, String password) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (null != account) {
                predicates.add(cb.equal(root.<String>get("accountNo"), account));
            }

            if (StringUtils.hasLength(password)) {
                predicates.add(cb.equal(root.<String>get("pwd"), password));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
