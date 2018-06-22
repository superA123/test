package com.cloud.support.constant;

/**
 * 常量类
 * 
 * @author Clark
 * @date 2015年12月11日
 */
public class WechatConstants extends Constants{
	/** 版本号 */
	public static final String VersionNo01 = "01";

	/** 结果代码 成功 00 */
	public static final String ResultSuccess = "00";
	/** 结果代码 失败 01 */
	public static final String ResultFailure = "01";

	/**
	 * 推送消息类型
	 * 
	 * @author Clark
	 * @version 2016-08-08
	 */
	public static class MsgType {

		/** 图文推送 */
		public static final String NEWS = "news";
	}

	/**
	 * 错误代码常量类
	 * 
	 * @author Clark
	 * @version 2016-08-08
	 */
	public static class ErrorNo extends com.cloud.support.constant.Constants.ErrorNo{
		/** 错误代码 网络异常 E0901 */
		public static final String Error0901 = "E0901";
	}
	
	/**
	 * 错误代码常量类
	 * 
	 * @author Clark
	 * @version 2016-08-08
	 */
	public static class Status {
		/** 绑定身份成功 */
		public static final String Binding0 = "0";
		/** 绑定身份失败 */
		public static final String Binding1 = "1";
		/** 绑定身份重复 */
		public static final String Binding2 = "2";

		/** 检验身份成功 */
		public static final String CheckBinding0 = "0";
		/** 已绑定标识 */
		public static final String CheckBindingIsExist0 = "0";
		
		/** Survey成功 */
		public static final String Survey0 = "0";
		/** Survey重复提交 */
		public static final String Survey2 = "2";
	}
}
