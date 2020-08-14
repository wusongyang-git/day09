package com.xiaoshu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.AreaMapper;
import com.xiaoshu.dao.SchoolMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Area;
import com.xiaoshu.entity.School;
import com.xiaoshu.entity.SchoolVo;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class SchoolService {

	@Autowired
	UserMapper userMapper;
	@Autowired
	SchoolMapper schoolMapper;
	@Autowired
	AreaMapper areaMapper;

	public Object findArea(Area area) {
		// TODO Auto-generated method stub
		
		return areaMapper.selectAll();
	}

	public PageInfo<SchoolVo> findPage(SchoolVo schoolVo, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SchoolVo> list=schoolMapper.findList(schoolVo);
		return new PageInfo<SchoolVo>(list);
	}

	public School findByName(String schoolname) {
		// TODO Auto-generated method stub
		School parm=new School();
		parm.setSchoolname(schoolname);
		return schoolMapper.selectOne(parm);
	}

	public void addSchool(School school) {
		// TODO Auto-generated method stub
		school.setCreatetime(new Date());
		schoolMapper.insert(school);
	}

	public void updateSchool(School school) {
		// TODO Auto-generated method stub
		schoolMapper.updateByPrimaryKeySelective(school);
	}

	public List<SchoolVo> findList(SchoolVo schoolVo) {
		// TODO Auto-generated method stub
		return schoolMapper.findList(schoolVo);
	}



}
