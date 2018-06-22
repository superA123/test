package com.cloud.jeesite.core.modules.sys.dao;

import com.cloud.jeesite.core.common.persistence.CrudDao;
import com.cloud.jeesite.core.common.persistence.annotation.MyBatisDao;
import com.cloud.jeesite.core.modules.sys.entity.SysStudent;

/**
 * 学生管理DAO接口
 * @author Li
 * @version 2018-05-17
 */
@MyBatisDao
public interface SysStudentDao extends CrudDao<SysStudent> {
	
}