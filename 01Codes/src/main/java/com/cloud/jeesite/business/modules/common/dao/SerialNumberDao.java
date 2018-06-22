package com.cloud.jeesite.business.modules.common.dao;

import org.apache.ibatis.annotations.Param;

import com.cloud.jeesite.business.modules.common.entity.SerialNumber;
import com.cloud.jeesite.core.common.persistence.CrudDao;
import com.cloud.jeesite.core.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface SerialNumberDao extends CrudDao<SerialNumber> {
	public SerialNumber findByBusinessType(@Param(value = "sequenceDate") String sequenceDate,
			@Param(value = "businessType") String businessType);
}