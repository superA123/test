package com.cloud.jeesite.core.modules.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloud.jeesite.core.common.config.Global;
import com.cloud.jeesite.core.common.persistence.Page;
import com.cloud.jeesite.core.common.web.BaseController;
import com.cloud.jeesite.core.common.utils.StringUtils;
import com.cloud.jeesite.core.modules.sys.entity.SysInform;
import com.cloud.jeesite.core.modules.sys.service.SysInformService;

/**
 * 通知公告Controller
 * @author Li
 * @version 2018-04-26
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysInform")
public class SysInformController extends BaseController {

	@Autowired
	private SysInformService sysInformService;
	
	@ModelAttribute
	public SysInform get(@RequestParam(required=false) String id) {
		SysInform entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysInformService.get(id);
		}
		if (entity == null){
			entity = new SysInform();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:sysInform:view")
	@RequestMapping(value = {"index"})
	public String index(SysInform sysInform, Model model){
		return "modules/sys/sysInformIndex";
	}

	
	@RequiresPermissions("sys:sysInform:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysInform sysInform, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysInform> page = sysInformService.findPage(new Page<SysInform>(request, response), sysInform); 
		model.addAttribute("page", page);
		return "modules/sys/sysInformList";
	}

	@RequiresPermissions("sys:sysInform:view")
	@RequestMapping(value = "form")
	public String form(SysInform sysInform, Model model) {
		model.addAttribute("sysInform", sysInform);
		return "modules/sys/sysInformForm";
	}

	@RequiresPermissions("sys:sysInform:edit")
	@RequestMapping(value = "save")
	public String save(SysInform sysInform, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysInform)){
			return form(sysInform, model);
		}
		sysInformService.save(sysInform);
		addMessage(redirectAttributes, "保存success成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysInform/?repage";
	}
	
	@RequiresPermissions("sys:sysInform:edit")
	@RequestMapping(value = "delete")
	public String delete(SysInform sysInform, RedirectAttributes redirectAttributes) {
		sysInformService.delete(sysInform);
		addMessage(redirectAttributes, "删除success成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysInform/?repage";
	}

}