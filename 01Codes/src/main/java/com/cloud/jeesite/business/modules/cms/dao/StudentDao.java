package com.cloud.jeesite.business.modules.cms.dao;

import com.cloud.jeesite.core.common.persistence.CrudDao;
import com.cloud.jeesite.core.common.persistence.annotation.MyBatisDao;
import com.cloud.jeesite.business.modules.cms.entity.Student;


@MyBatisDao
public interface StudentDao extends CrudDao<Student> {
	
}