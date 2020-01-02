package com.xgm.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xgm.bean.Goods;
import com.xgm.bean.Type;
import com.xgm.mapper.GoodsMapper;
@Service
public class GoodsServiceImpl implements GoodsService {

	@Resource
	private GoodsMapper mapper;
	
	public List<Goods> queryGoods(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.queryGoods(map);
	}

	public List<Type> queryType() {
		// TODO Auto-generated method stub
		return mapper.queryType();
	}

	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		mapper.addGoods(goods);
	}

	public void deleteGoods(String ids) {
		// TODO Auto-generated method stub
		mapper.deleteGoods(ids);
	}

	public Goods queryGoodsById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.queryGoodsById(id);
	}

}
