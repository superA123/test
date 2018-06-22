package com.cloud.jeesite.core.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.jeesite.core.common.persistence.Page;
import com.cloud.jeesite.core.common.service.CrudService;
import com.cloud.jeesite.core.modules.sys.entity.SysStudent;
import com.cloud.jeesite.core.modules.sys.dao.SysStudentDao;

/**
 * 学生管理Service
 * @author Li
 * @version 2018-05-17
 */
@Service
@Transactional(readOnly = true)
public class SysStudentService extends CrudService<SysStudentDao, SysStudent> {

	public SysStudent get(String id) {
		return super.get(id);
	}
	
	public List<SysStudent> findList(SysStudent sysStudent) {
		return super.findList(sysStudent);
	}
	
	public Page<SysStudent> findPage(Page<SysStudent> page, SysStudent sysStudent) {
		return super.findPage(page, sysStudent);
	}
	
	@Transactional(readOnly = false)
	public void save(SysStudent sysStudent) {
		super.save(sysStudent);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysStudent sysStudent) {
		super.delete(sysStudent);
	}
	
}