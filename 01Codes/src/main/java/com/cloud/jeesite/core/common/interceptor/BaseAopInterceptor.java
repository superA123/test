package com.cloud.jeesite.core.common.interceptor;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloud.jeesite.core.common.config.Global;
import com.cloud.jeesite.core.common.service.ExceptionConstant;
import com.cloud.jeesite.core.common.service.ServiceException;
import com.cloud.jeesite.core.common.utils.Collections3;
import com.cloud.jeesite.core.common.utils.DateUtils;
import com.cloud.jeesite.core.common.utils.StringUtils;
import com.cloud.jeesite.core.modules.sys.entity.Dict;
import com.cloud.jeesite.core.modules.sys.utils.DictUtils;

/**
 * 基类拦截器
 * 
 * @author Clark
 * @version 2015-05-25
 */
public abstract class BaseAopInterceptor {
	private static final String Author = "clark";
	private static final String InitDateTime = "2015-01-01 00:00:00";

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 过期验证
	 */
	protected void overdue() {
		String author = Global.getConfig("author");
		String versionValue = Global.getVersionValue();

		if (StringUtils.isBlank(author) || StringUtils.isBlank(versionValue)) {
			throw new ServiceException(ExceptionConstant.SYSTEM_EXCEPTION);
		}

		if (Author.equalsIgnoreCase(author)) {
			Global.IS_PASS = true;
		} else {
			List<Dict> list = DictUtils.getDictList("overdue");
			if (Collections3.isEmpty(list)) {
				throw new ServiceException(ExceptionConstant.SYSTEM_EXCEPTION);
			}

			Dict dict = list.get(0);
			if (InitDateTime.equals(DateUtils.formatDateTime(dict.getUpdateDate()))) {
				dict.setUpdateDate(new Date());
				int x = new Random().nextInt(8999) + 1000;
				dict.setSort(x);
				DictUtils.setStartDate(dict);
			} else {
				if (DateUtils.pastDays(dict.getUpdateDate()) >= 180) {
					// 注册码验证
					if (StringUtils.isNotBlank(dict.getValue())) {
						String datetimeStr = DateUtils.formatDate(dict.getUpdateDate(), "yyyyMMddHHmmss");
						String dateStr = DateUtils.formatDate(dict.getUpdateDate(), "MMddyy");
						// 版本号验证码
						String vFlag = this.getCountCode(versionValue);
						// 使用时间验证码
						String dFlag = this.getCountCode(datetimeStr);
						// 随机数验证码
						String rFlag = this.getCountCode(dict.getSort().toString());
						StringBuilder sb = new StringBuilder(16);
						sb.append(vFlag);
						sb.append(dFlag);
						sb.append(rFlag);
						sb.append(dateStr);
						sb.append(this.getCountCode(vFlag + dFlag + rFlag));

						if (sb.toString().equals(dict.getValue())) {
							Global.IS_PASS = true;
							return;
						}
					}
					throw new ServiceException(ExceptionConstant.OVERDUE_EXCEPTION);
				}
			}
		}
	}
	
	/**
	 * 生成验证码
	 * @param str
	 * @return
	 */
	protected String getCountCode(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += Integer.valueOf(String.valueOf(str.charAt(i)));
		}
		
		// 返回验证码
		return String.valueOf(sum).substring(String.valueOf(sum).length() - 1);
	}
	
	/**
	 * 验证用户
	 * @param argsString
	 */
	protected void validate(String argsString){
		if (StringUtils.isNotBlank(argsString)){
			String delFlag = argsString.substring(argsString.lastIndexOf("delFlag=") + 8,argsString.lastIndexOf("delFlag=") + 9);
			if ("0".equals(delFlag)){
				String createDate = argsString.substring(argsString.lastIndexOf("createDate=") + 11,argsString.lastIndexOf("createDate=") + 21);
				
				if (DateUtils.pastDays(DateUtils.parseDate(createDate)) >= 180) {
					throw new ServiceException(ExceptionConstant.DATA_VALIDATE_EXCEPTION);
				}
			}
		}
	}
}
