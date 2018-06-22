package com.cloud.support.utils;

import com.cloud.jeesite.business.modules.common.service.SerialNumberService;
import com.cloud.jeesite.core.common.config.Global;
import com.cloud.jeesite.core.common.utils.SpringContextHolder;
import com.cloud.jeesite.core.common.utils.StringUtils;
import com.cloud.jeesite.core.modules.sys.entity.Office;

/**
 * 业务工具类
 * 
 * @author Clark
 * @version 2016-11-01
 */
public class BusinessUtils extends CommonUtils {

	/**
	 * 根据业务生成自增序列
	 */
	private static SerialNumberService serialNumberService = SpringContextHolder.getBean(SerialNumberService.class);

	/**
	 * 根据不同业务生成流水单号
	 * 
	 * @author Clark
	 * @version 2016-11-01
	 * 
	 * @param businessType
	 * @return
	 */
	public static synchronized String getNewBusinessNo(String businessType, Office office) {
		String officeCode = "";
		// 是否使用机构编号开关
		String usedOffice = Global.getConfig("business.serialNo.usedOfficeCode");
		if (StringUtils.isNotBlank(usedOffice)) {
			officeCode = office != null ? office.getCode() : "";
		}
		// 自增序列长度
		int seqLength = Integer.parseInt(Global.getConfig("business.serialNo.seqLength"));
		// 当前序列号
		int seqNo = serialNumberService.getSerialNumber(businessType);
		// 生成新的业务流水
		return CommonUtils.createSerialNo(officeCode, businessType, seqNo, seqLength);
	}
}
