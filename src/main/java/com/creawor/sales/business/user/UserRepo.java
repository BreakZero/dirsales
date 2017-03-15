package com.creawor.sales.business.user;


import com.creawor.sales.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Jin_ on 2016/11/10.
 *
 */
public interface UserRepo extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

}
