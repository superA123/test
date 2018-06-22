package com.cloud.jeesite.core.modules.sys.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloud.jeesite.core.common.config.Global;
import com.cloud.jeesite.core.common.persistence.Page;
import com.cloud.jeesite.core.common.utils.StringUtils;
import com.cloud.jeesite.core.common.web.BaseController;
import com.cloud.jeesite.core.modules.sys.entity.Classes;
import com.cloud.jeesite.core.modules.sys.entity.SysStudent;
import com.cloud.jeesite.core.modules.sys.entity.User;
import com.cloud.jeesite.core.modules.sys.service.ClassesService;
import com.cloud.jeesite.core.modules.sys.service.SysStudentService;
import com.cloud.jeesite.core.modules.sys.utils.UserUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;


@Controller
@RequestMapping(value = "${adminPath}/sys/classes")
public class ClassesController extends BaseController {

	@Autowired
	private ClassesService classesService;
	
	@Autowired
	private SysStudentService sysStudentService;
	
	@ModelAttribute
	public Classes get(@RequestParam(required=false) String id) {
		Classes entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = classesService.get(id);
		}
		if (entity == null){
			entity = new Classes();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:classes:view")
	@RequestMapping(value = {"list", ""})
	public String list(Classes classes, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user=UserUtils.getUser();
		if(!user.getLoginName().equals("clark")){
			classes.setMasterId(user.getNo());
		}
		Page<Classes> page = classesService.findList(new Page<Classes>(request, response), classes);
		model.addAttribute("page", page);
		return "modules/sys/classesList";
	}

	@RequiresPermissions("sys:classes:view")
	@RequestMapping(value = "form")
	public String form(Classes classes, Model model) {
		model.addAttribute("classes", classes);
		return "modules/sys/classesForm";
	}

	@RequiresPermissions("sys:classes:edit")
	@RequestMapping(value = "save")
	public String save(Classes classes, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, classes)){
			return form(classes, model);
		}
		classesService.save(classes);
		addMessage(redirectAttributes, "保存班级成功");
		return "redirect:"+Global.getAdminPath()+"/sys/classes/?repage";
	}
	
	@RequiresPermissions("sys:classes:edit")
	@RequestMapping(value = "delete")
	public String delete(Classes classes, RedirectAttributes redirectAttributes) {
		Classes classess=classesService.get(classes.getId());
		SysStudent sysStudent=new SysStudent();
		sysStudent.setClassid(classess.getCode());
		List<SysStudent> studentList = sysStudentService.findList(sysStudent);
 		
		if(studentList.size()>0){
			addMessage(redirectAttributes, "删除失败，请先删除该班级下的所有学生！");
			return "redirect:"+Global.getAdminPath()+"/sys/classes/?repage";
		}
		classesService.delete(classes);
		addMessage(redirectAttributes, "删除班级成功");
		return "redirect:"+Global.getAdminPath()+"/sys/classes/?repage";
	}
	/**
	 * 获取机构JSON数据。
	 * 
	 * @param extId
	 *            排除的ID
	 * @param type
	 *            类型（1：总公司；2：分公司：3：用户）
	 * @param grade
	 *            显示级别
	 * @param response
	 * @return
	 */
	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required = false) String extId, @RequestParam(required = false) String type, @RequestParam(required = false) Long grade, @RequestParam(required = false) Boolean isAll, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		User User = new User();
		List<User> list = UserUtils.getList("2");
		for (int i = 0; i < list.size(); i++) {
			User e = list.get(i);
			if ((StringUtils.isBlank(extId) || extId != null && !extId.equals(""))) {
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				// map.put("pIds", e.getPids());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}

}