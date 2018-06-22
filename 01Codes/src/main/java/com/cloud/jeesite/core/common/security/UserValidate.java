package com.cloud.jeesite.core.common.security;

import com.cloud.jeesite.core.common.utils.DateUtils;

/**
 * @author Clark
 * @version 2015-12-20
 * 
 * 验证当前用户是否过期
 */
public class UserValidate {

	/**
	 * 验证当前用户有效性
	 * 
	 * @param args：第一位是delFlag、第二位是createDate
	 * @return
	 */
	public static boolean checkUser(String... args) {
		if (args != null && args.length > 0) {
			if ("0".equals(args[0])) {
				if (DateUtils.pastDays(DateUtils.parseDate(args[1])) >= 180) {
					return false;
				}
			}
		}

		return true;
	}
}
