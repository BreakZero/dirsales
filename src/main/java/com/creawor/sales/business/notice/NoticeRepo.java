package com.creawor.sales.business.notice;

import com.creawor.sales.model.NoticeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Zero on 2017/3/10.
 * 通知信息Dao层
 */
public interface NoticeRepo extends JpaRepository<NoticeInfo, String>, JpaSpecificationExecutor<NoticeInfo> {

}
