package com.creawor.sales.business.cust;

import com.creawor.sales.common.ICommonService;
import com.creawor.sales.model.Customer;
import com.creawor.sales.model.SalesTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Zero on 2017/3/10.
 * 面向接口接口定义
 */
public interface ICustService extends ICommonService<Customer> {
    Page<Customer> findAll(Pageable pageable, String excuId);
    int getCount(String excuId);
    int getMarketCount(String excuId);
    int getOrderCount(String excuId);
}
