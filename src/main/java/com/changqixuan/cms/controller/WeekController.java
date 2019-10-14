/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: WeekController.java 
 * @Prject: week02
 * @Package: com.changqixuan.cms.controller 
 * @Description: TODO
 * @author: lenovo   
 * @date: 2019年10月14日 上午9:18:34 
 * @version: V1.0   
 */
package com.changqixuan.cms.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.changqixuan.cms.domain.Goods;

/** 
 * @ClassName: WeekController 
 * @Description: TODO
 * @author: 常琪宣
 * @date: 2019年10月14日 上午9:18:34  
 */
@Controller
public class WeekController {

	@SuppressWarnings("rawtypes")
	@Autowired
	RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("listshow")
	public String listshow(Model model,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "10")Integer pageSize){
		Long size = redisTemplate.opsForList().size("goods_list");
		Long pages = size%pageSize==0?size%pageSize:size/pageSize+1;
		List<Goods> list = redisTemplate.opsForList().range("goods_list",(page-1)*pageSize,(page-1)*pageSize+pageSize-1);
		model.addAttribute("list",list);
		model.addAttribute("page",page);
		model.addAttribute("pages",pages);
		return "list";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("zsetshow")
	public String zsetshow(Model model,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "10")Integer pageSize){
		Long size = redisTemplate.opsForZSet().size("goods_zset");
		Long pages = size%pageSize==0?size%pageSize:size/pageSize+1;
		Set<Goods> set = redisTemplate.opsForZSet().reverseRange("goods_zset",(page-1)*pageSize,(page-1)*pageSize+pageSize-1);
		model.addAttribute("set",set);
		model.addAttribute("page",page);
		model.addAttribute("pages",pages);
		return "setshow";
	}
}
