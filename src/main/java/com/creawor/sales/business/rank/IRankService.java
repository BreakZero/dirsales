package com.creawor.sales.business.rank;

import com.creawor.sales.common.ICommonService;
import com.creawor.sales.model.TaskRankInfo;

/**
 * Created by Zero on 2017/3/10.
 * 面向接口接口定义--任务排行
 */
interface IRankService extends ICommonService<TaskRankInfo> {
    TaskRankInfo findOne(String phone, String actId);
}
