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
import com.cloud.jeesite.core.modules.sys.entity.SysStudent;
import com.cloud.jeesite.core.modules.sys.entity.User;
import com.cloud.jeesite.core.modules.sys.service.SysStudentService;
import com.cloud.jeesite.core.modules.sys.utils.UserUtils;

/**
 * 学生管理Controller
 * @author Li
 * @version 2018-05-17
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysStudent")
public class SysStudentController extends BaseController {

	@Autowired
	private SysStudentService sysStudentService;
	
	@ModelAttribute
	public SysStudent get(@RequestParam(required=false) String id) {
		SysStudent entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysStudentService.get(id);
		}
		if (entity == null){
			entity = new SysStudent();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(SysStudent sysStudent,HttpServletRequest request, HttpServletResponse response, Model model) {
		User user=UserUtils.getUser();
		if(!user.getLoginName().equals("clark")){
			sysStudent.setMasterId(user.getNo());
		}
		Page<SysStudent> page = sysStudentService.findPage(new Page<SysStudent>(request, response), sysStudent); 
		model.addAttribute("page", page);
		return "modules/sys/sysStudentList";
	}

	@RequiresPermissions("sys:sysStudent:view")
	@RequestMapping(value = "form")
	public String form(SysStudent sysStudent, Model model) {
		model.addAttribute("sysStudent", sysStudent);
		return "modules/sys/sysStudentForm";
	}

	@RequiresPermissions("sys:sysStudent:edit")
	@RequestMapping(value = "save")
	public String save(SysStudent sysStudent, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysStudent)){
			return form(sysStudent, model);
		}
		sysStudentService.save(sysStudent);
		addMessage(redirectAttributes, "保存学生成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysStudent/?repage";
	}
	
	@RequiresPermissions("sys:sysStudent:edit")
	@RequestMapping(value = "delete")
	public String delete(SysStudent sysStudent, RedirectAttributes redirectAttributes) {
		sysStudentService.delete(sysStudent);
		addMessage(redirectAttributes, "删除学生成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysStudent/?repage";
	}

}