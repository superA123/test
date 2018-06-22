package com.cloud.jeesite.core.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.jeesite.core.common.persistence.Page;
import com.cloud.jeesite.core.common.service.CrudService;
import com.cloud.jeesite.core.modules.sys.entity.SysInform;
import com.cloud.jeesite.core.modules.sys.dao.SysInformDao;

/**
 * 通知公告Service
 * @author Li
 * @version 2018-04-26
 */
@Service
@Transactional(readOnly = true)
public class SysInformService extends CrudService<SysInformDao, SysInform> {

	public SysInform get(String id) {
		return super.get(id);
	}
	
	public List<SysInform> findList(SysInform sysInform) {
		return super.findList(sysInform);
	}
	
	public Page<SysInform> findPage(Page<SysInform> page, SysInform sysInform) {
		return super.findPage(page, sysInform);
	}
	
	@Transactional(readOnly = false)
	public void save(SysInform sysInform) {
		super.save(sysInform);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysInform sysInform) {
		super.delete(sysInform);
	}
	
}