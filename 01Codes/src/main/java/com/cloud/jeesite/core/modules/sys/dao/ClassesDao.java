package com.cloud.jeesite.core.modules.sys.dao;

import java.util.List;

import com.cloud.jeesite.core.common.persistence.CrudDao;
import com.cloud.jeesite.core.common.persistence.annotation.MyBatisDao;
import com.cloud.jeesite.core.modules.sys.entity.Classes;

/**
 * 班级管理DAO接口
 * @author Li
 * @version 2018-04-29
 */
@MyBatisDao
public interface ClassesDao extends CrudDao<Classes> {
	 
	public List<Classes> findMaster(Classes classes);
		
}