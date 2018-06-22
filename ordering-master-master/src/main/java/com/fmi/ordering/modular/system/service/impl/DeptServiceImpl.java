package com.fmi.ordering.modular.system.service.impl;

import com.fmi.ordering.common.persistence.dao.DeptMapper;
import com.fmi.ordering.common.persistence.model.Dept;
import com.fmi.ordering.modular.system.service.IDeptService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class DeptServiceImpl implements IDeptService {

    @Resource
    DeptMapper deptMapper;

    @Override
    public void deleteDept(Integer deptId) {
        Dept dept = deptMapper.selectByPrimaryKey(deptId);
        Example example = new Example(Dept.class);
        example.createCriteria().andLike("pids", "%[" + dept.getId() + "]%");
        List<Dept> subDepts = deptMapper.selectByExample(example);
        for (Dept temp : subDepts) {
            deptMapper.deleteByPrimaryKey(temp);
        }
        deptMapper.deleteByPrimaryKey(deptId);
    }
}
