/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cloud.jeesite.business.modules.cms.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.jeesite.business.modules.cms.dao.ArticleDataDao;
import com.cloud.jeesite.business.modules.cms.entity.ArticleData;
import com.cloud.jeesite.core.common.service.CrudService;


@Service
@Transactional(readOnly = true)
public class ArticleDataService extends CrudService<ArticleDataDao, ArticleData> {

}
