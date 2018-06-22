package com.cloud.jeesite.core.modules.sys.dao;

import com.cloud.jeesite.core.common.persistence.CrudDao;
import com.cloud.jeesite.core.common.persistence.annotation.MyBatisDao;
import com.cloud.jeesite.core.modules.sys.entity.SysInform;

/**
 * 通知公告DAO接口
 * @author Li
 * @version 2018-04-26
 */
@MyBatisDao
public interface SysInformDao extends CrudDao<SysInform> {
	
}