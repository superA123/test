/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cloud.jeesite.business.modules.cms.dao;

import com.cloud.jeesite.business.modules.cms.entity.ArticleData;
import com.cloud.jeesite.core.common.persistence.CrudDao;
import com.cloud.jeesite.core.common.persistence.annotation.MyBatisDao;


@MyBatisDao
public interface ArticleDataDao extends CrudDao<ArticleData> {
	
}
