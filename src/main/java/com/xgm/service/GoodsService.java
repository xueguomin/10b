package com.xgm.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xgm.bean.Goods;
import com.xgm.bean.Type;

public interface GoodsService {

	public List<Goods> queryGoods(Map<String, Object>map);
	
	public List<Type> queryType();
	
	public void addGoods(Goods goods);
	
	public void deleteGoods(@Param("id")String ids);
	
	public Goods queryGoodsById(@Param("id")Integer id);
}
