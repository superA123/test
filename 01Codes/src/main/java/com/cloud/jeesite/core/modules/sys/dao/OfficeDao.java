/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cloud.jeesite.core.modules.sys.dao;

import com.cloud.jeesite.core.common.persistence.TreeDao;
import com.cloud.jeesite.core.common.persistence.annotation.MyBatisDao;
import com.cloud.jeesite.core.modules.sys.entity.Office;


@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {
	
}
