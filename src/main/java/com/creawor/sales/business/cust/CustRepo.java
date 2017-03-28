package com.creawor.sales.business.cust;

import com.creawor.sales.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Zero on 2017/3/10.
 * 营销客户Dao层
 */
public interface CustRepo extends JpaRepository<Customer, String>, JpaSpecificationExecutor<Customer> {
    @Query("select count(cust.executeId) from Customer cust where cust.executeId = :excuId")
    int getCount(@Param("excuId") String excuId);

    @Query("select count(cust.executeId) from Customer cust where cust.executeId = :excuId" +
            " and cust.ifOrder = '1'")
    int getMarketCount(@Param("excuId") String excuId);

    @Query("select count(cust.executeId) from Customer cust where cust.executeId = :excuId" +
            " and cust.marketState = '1'")
    int getOrderCount(@Param("excuId") String excuId);
}
