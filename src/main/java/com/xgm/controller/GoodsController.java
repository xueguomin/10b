package com.xgm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgm.bean.Goods;
import com.xgm.bean.Type;
import com.xgm.service.GoodsService;

@Controller
public class GoodsController {

	@Resource
	private GoodsService service;
	
	@RequestMapping("queryGoods")
	public String query(Model model,@RequestParam(defaultValue="1")Integer pageNum,String name){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", name);
		PageHelper.startPage(pageNum, 2);
		List<Goods> list = service.queryGoods(map);
		PageInfo<Goods> page = new PageInfo<Goods>(list);
		model.addAttribute("page", page);
		return "list";
		
	}
	
	@RequestMapping("queryType")
	@ResponseBody
	public List<Type> queryType(){
		List<Type> list = service.queryType();
		return list;
		
	}
	
	@RequestMapping("queryGoodsById")
	public String queryGoodsById(Integer id,Model model){
		Goods goods = service.queryGoodsById(id);
		model.addAttribute("goods", goods);
		return "show";
		
	}
	
	@RequestMapping("addGoods")
	@ResponseBody
	public boolean addGoods(Goods goods){
		try {
			goods.setStatus(0);
			service.addGoods(goods);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;			
		}
		
	}
	
}
