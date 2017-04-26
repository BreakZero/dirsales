package com.creawor.sales.business.notice;

import com.creawor.sales.common.ICommonService;
import com.creawor.sales.model.NoticeInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Zero on 2017/3/10.
 * 面向接口接口定义--通知信息模块
 */
interface INoticeService extends ICommonService<NoticeInfo> {
    Page<NoticeInfo> findAll(Pageable pageable, String type);
}
