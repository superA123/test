package com.cloud.support.utils;

import java.util.Calendar;
import java.util.Random;

import com.cloud.jeesite.core.common.config.Global;
import com.cloud.jeesite.core.common.utils.DateUtils;
import com.cloud.support.constant.Constants;

/**
 * 共同处理类
 * 
 * @author ChengShu
 * @version 2014-11-12
 */
public abstract class CommonUtils {
	
	/**
	 * 生成验证码
	 *
	 * @author Clark
	 * @version 2016年10月20日 
	 *  
	 * @return
	 */
	public static String getVerificationCode() {
		String min = Global.getConfig("sms_verificationCode_min"); 
		String max = Global.getConfig("sms_verificationCode_max"); 
		Random random = new Random();
		Integer num = random.nextInt(Integer.valueOf(max)) + Integer.valueOf(min);
		return num.toString();
	}

	/**
	 * 生成业务流水
	 * 
	 * @author Clark
	 * @version 2015年5月14日
	 * 
	 * @param officeCode
	 * @param businessType
	 * @param seqNo
	 * @param seqLength
	 * @return
	 */
	public static String createSerialNo(String officeCode, String businessType, int seqNo, int seqLength) {
		// 当前日期
		String dateString = DateUtils.getDate(Constants.Dates.FORMATE_YYMMDD);

		// 业务流水：机构编号+当日日期（yyMMdd）+业务类型（2位）+自增序列
		return officeCode + dateString + businessType + fillSeqNo(seqNo, seqLength);
	}

	/**
	 * 序列号左补齐
	 * 
	 * @author LF 
	 * @version 2014-12-5
	 * 
	 * @Description
	 * @param seqNo
	 *            序列号
	 * @param seqNoLen
	 *            补齐长度
	 * @return
	 */
	public static String fillSeqNo(int seqNo, int seqNoLen) {
		String str = String.valueOf(seqNo);
		int len = str.length();

		if (len < seqNoLen && len > 0) {
			for (int i = 0; i < (seqNoLen - len); i++) {
				str = "0" + str;
			}
		}
		return str;
	}

	/**
	 * 全角转半角
	 * 
	 * @param boxNo
	 *            箱号
	 * @return 半角字符串
	 */
	public static String toDBC(String boxNo) {

		// 全角对应于ASCII表的可见字符从！开始，偏移值为65281
		char SBC_CHAR_START = 65281;

		// 全角对应于ASCII表的可见字符到～结束，偏移值为65374
		char SBC_CHAR_END = 65374;

		// ASCII表中除空格外的可见字符与对应的全角字符的相对偏移
		int CONVERT_STEP = 65248;

		// 全角空格的值，它没有遵从与ASCII的相对偏移，必须单独处理
		char SBC_SPACE = 12288;

		// 半角空格的值，在ASCII中为32(Decimal)
		char DBC_SPACE = ' ';

		if (boxNo == null) {
			return boxNo;
		}
		StringBuilder buf = new StringBuilder(boxNo.length());
		char[] ca = boxNo.toCharArray();
		for (int i = 0; i < boxNo.length(); i++) {
			// 如果位于全角！到全角～区间内
			if (ca[i] >= SBC_CHAR_START && ca[i] <= SBC_CHAR_END) {
				buf.append((char) (ca[i] - CONVERT_STEP));
			} else if (ca[i] == SBC_SPACE) {
				// 如果是全角空格
				buf.append(DBC_SPACE);
			} else {
				// 不处理全角空格，全角！到全角～区间外的字符
				buf.append(ca[i]);
			}
		}
		return buf.toString();
	}

	/**
	 * 得到当前星期的数字表达【星期日~星期六 ：0~6】
	 * 
	 * @author Murphy
	 * @version 2015年1月9日
	 * 
	 * @return
	 */
	public static int getWeek() {
		Calendar c = Calendar.getInstance();
		int week = c.get(Calendar.DAY_OF_WEEK) - 1;
		return week;
	}

	/**
	 * 根据日期代码获得星期名
	 * 
	 * @author Murphy
	 * @version 2015年1月9日
	 * 
	 * @param weekCode
	 * @return
	 */
	public static String getWeekOfDate(int weekCode) {
		String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		return weekDaysName[weekCode];
	}
}
