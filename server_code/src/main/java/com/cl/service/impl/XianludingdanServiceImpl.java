package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.XianludingdanDao;
import com.cl.entity.XianludingdanEntity;
import com.cl.service.XianludingdanService;
import com.cl.entity.view.XianludingdanView;

@Service("xianludingdanService")
public class XianludingdanServiceImpl extends ServiceImpl<XianludingdanDao, XianludingdanEntity> implements XianludingdanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XianludingdanEntity> page = this.selectPage(
                new Query<XianludingdanEntity>(params).getPage(),
                new EntityWrapper<XianludingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XianludingdanEntity> wrapper) {
		  Page<XianludingdanView> page =new Query<XianludingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XianludingdanView> selectListView(Wrapper<XianludingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XianludingdanView selectView(Wrapper<XianludingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<XianludingdanEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<XianludingdanEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<XianludingdanEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
