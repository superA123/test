package com.cloud.support.constant;

import com.cloud.jeesite.core.common.service.ExceptionConstant;

/**
 * 常量类
 * 
 * @author Clark
 * @date 2015年12月11日
 */
public class Constants {

	/**
	 * 异常消息国际化标识key前缀
	 */
	public static final String MESSAGE_COMMON_ERROR_PREFIX = "message.common.";

	/** 处理成功失败相关（0：成功/1：失败） */
	public static final String SUCCESS = "0";
	public static final String FAILED = "1";

	/** 图形常量 */
	public static class Punctuation {
		/** 符号：半角逗号 */
		public static final String COMMA = ",";
		/** 符号：半角空格 */
		public static final String HALF_SPACE = " ";
		/** 符号：半角分号 */
		public static final String HALF_SEMICOLONE = ";";
		/** 符号：下划线 */
		public static final String HALF_UNDERLINE = "_";
	}

	/** 图形常量 */
	public static class Charts {
		public static final String PAGE_DATA = "pageData";
		public static final String TITLE_TEXT = "titleText";
		public static final String TITLE_SUB_TEXT = "titleSubText";
		public static final String SERIES_NAME = "seriesName";
		public static final String LEGEND_NAME = "legendName";
		public static final String LEGEND_DATA = "legendData";
		public static final String DATA = "data";
	}

	/** 日期常量 */
	public static class Dates {
		public static final String DATE_MIN = "1900-01-01";
		public static final String DATE_MAX = "9999-12-31";
		public static final String FORMATE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
		public static final String FORMATE_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
		public static final String FORMATE_YYYY_MM_DD = "yyyy-MM-dd";
		public static final String FORMATE_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
		/**
		 * 日期格式化：YYYYMMDD
		 */
		public static final String FORMATE_YYYYMMDD = "yyyyMMdd";
		/**
		 * 日期格式化：YYMMDD
		 */
		public static final String FORMATE_YYMMDD = "yyMMdd";
	}


	/** 机构类型 */
	public static class OfficeType {
		/** 机构类型 0：顶级机构；1：总金库；2：分金库；3：支行；4：网点 */
		public static final String ROOT = "0";
		public static final String HEAD_COFFERS = "1";
		public static final String BRANCH_COFFERS = "2";
		public static final String SUB_BRANCH = "3";
		public static final String OUTLETS = "4";
	}

	/** 系统用户类型 */
	public static class SysUserType {
		/**
		 * 系统用户类型 (10：系统管理员、 11：金库主管、 12：金库操作员、 13：整点室主管、 14：整点室操作员、 
		 *             15：网点主管、 16：网点操作员、 17：票据室主管、 18：票据室操作员)
		 */
		/** 10 系统管理员 */
		public static final String SYSTEM = "10";
		/** 11 金库主管 */
		public static final String COFFER_MANAGER = "11";
		/** 12 金库操作员 */
		public static final String COFFER_OPT = "12";
	}

	/**
	 * @author Clark 消息代码 例如：E1012：E代表错误消息，10：代表模块编号，12：代表消息编号
	 *         10：库房管理，20：调缴管理，30：整点清分，40：ATM配钞，50：上门收款
	 */
	public static class MessageCode {
		public static final String SUCCESS = "message.common.success";
		public static final String E1001 = "message.common.E1001";
	}
	
	/**
	 * 错误代码常量类
	 * 
	 * @author Clark
	 * @version 2016-08-08
	 */
	public static class ErrorNo {
		/** 错误代码 未知异常 E9999 */
		public static final String Error9999 = "E9999";
		
		/** 错误代码 系统内部异常 E0101 */
		public static final String Error0101 = ExceptionConstant.SYSTEM_EXCEPTION;
		/** 错误代码 数据库访问异常 E0102 */
		public static final String Error0102 = ExceptionConstant.DB_CONNECTION_EXCEPTION;
		/** 错误代码 参数异常 E0103 */
		public static final String Error0103 = ExceptionConstant.DATA_VALIDATE_EXCEPTION;
	}
}
