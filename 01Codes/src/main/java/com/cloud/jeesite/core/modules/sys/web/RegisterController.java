package com.cloud.jeesite.core.modules.sys.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cloud.jeesite.core.common.config.Global;
import com.cloud.jeesite.core.common.service.BusinessException;
import com.cloud.jeesite.core.common.utils.CacheUtils;
import com.cloud.jeesite.core.common.utils.DateUtils;
import com.cloud.jeesite.core.common.utils.MailUtils;
import com.cloud.jeesite.core.common.web.BaseController;
import com.cloud.jeesite.core.modules.sys.entity.Dict;
import com.cloud.jeesite.core.modules.sys.service.DictService;
import com.google.common.collect.Maps;

/**
 * 注册Controller
 * @author Clark
 * @version 2015-12-31
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/register")
@SessionAttributes("registerInfo")
public class RegisterController extends BaseController {

	@Autowired
	private DictService dictService;
	
	@RequestMapping(value = {"info", ""})
	public String info(Dict dict, Model model) {
		dict = dictService.get(dict);
		model.addAttribute("registerInfo", dict);  

		Map<String, Object> map = Maps.newHashMap();
		map.put("createDate", dict.getUpdateDate());
		map.put("updateDate", DateUtils.addDays(dict.getUpdateDate(), 180));
		map.put("clientNo", dict.getSort());
		map.put("version", Global.getConfig("version"));
		model.addAttribute("map", map);
		return "modules/sys/sysInfo";
	}
	
	@RequestMapping(value = { "save", "" })
	public String save(@ModelAttribute("registerInfo") Dict dict, @RequestParam Map<String, Object> paramMap,
			Model model) {
		if (!isRegistered(paramMap)) {
			paramMap.put("productName", Global.getConfig("productName"));
			paramMap.put("version", Global.getConfig("version"));
			paramMap.put("author", Global.getConfig("author"));
			paramMap.put("copyrightYear", Global.getConfig("copyrightYear"));
			paramMap.put("mailValidation", Global.getConfig("mailValidation"));
			paramMap.put("clientNo", dict.getSort());
			paramMap.put("createDate", DateUtils.formatDateTime(dict.getUpdateDate()));

			try {
				String templatePath = "mailTemplate/register.ftl";
//				MailUtils.sendTemplateMail(Global.getConfig("sendRegisterInfoToMail"), "注册申请", templatePath, paramMap);
				addMessage(model, "注册申请成功，请等待邮件或电话回复。");
			} catch (BusinessException e) {
				addMessage(model, "注册申请失败，请与厂商联系。");
			}
		} else {
			addMessage(model, "已经申请注册，请等待邮件或电话回复。");
		}
		
		paramMap.put("createDate", dict.getUpdateDate());
		paramMap.put("updateDate", DateUtils.addDays(dict.getUpdateDate(), 180));
		model.addAttribute("map", paramMap);
		return "modules/sys/sysInfo";
	}

	/**
	 * 判断是否曾经申请注册
	 * @param paramMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean isRegistered(Map<String, Object> paramMap) {
		Map<String, Object> registerInfo = (Map<String, Object>)CacheUtils.get("registerInfo");
		if (registerInfo != null) {
			if (paramMap.get("mobile").toString().equals(registerInfo.get("mobile").toString()) && paramMap
					.get("registerMail").toString().equalsIgnoreCase(registerInfo.get("registerMail").toString())) {
				return true;
			}
		}
		
		CacheUtils.put("registerInfo", paramMap);
		return false;
	}
}
