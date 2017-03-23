package com.creawor.sales.business.cust;

import com.creawor.sales.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Zero on 2017/3/10.
 *
 */
public interface CustRepo extends JpaRepository<Customer, String>, JpaSpecificationExecutor<Customer> {

}
