package com.creawor.sales.business.user;


import com.creawor.sales.common.ICommonService;
import com.creawor.sales.model.User;

/**
 * Created by Jin_ on 2016/11/10.
 *
 */
public interface IUserService extends ICommonService<User> {
    User findOne(String account, String password);
}
