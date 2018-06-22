package com.cloud.jeesite.core.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.jeesite.core.common.persistence.Page;
import com.cloud.jeesite.core.common.service.CrudService;
import com.cloud.jeesite.core.modules.sys.entity.Classes;
import com.cloud.jeesite.core.modules.sys.dao.ClassesDao;

/**
 * 班级管理Service
 * @author Li
 * @version 2018-04-29
 */
@Service
@Transactional(readOnly = true)
public class ClassesService extends CrudService<ClassesDao, Classes> {

	public Classes get(String id) {
		return super.get(id);
	}
	
	public List<Classes> findList(Classes classes) {
		return super.findList(classes);
	}

	public Page<Classes> findPage(Page<Classes> page, Classes classes) {
		return super.findPage(page, classes);
	}
	
	@Transactional(readOnly = false)
	public void save(Classes classes) {
		super.save(classes);
	}
	
	@Transactional(readOnly = false)
	public void delete(Classes classes) {
		super.delete(classes);
	}
	
}