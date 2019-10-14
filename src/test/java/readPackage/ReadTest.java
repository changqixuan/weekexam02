/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: ReadTest.java 
 * @Prject: week02
 * @Package: ReadPackage 
 * @Description: TODO
 * @author: lenovo   
 * @date: 2019年10月14日 上午8:49:06 
 * @version: V1.0   
 */
package readPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.changqixuan.cms.domain.Goods;
import com.changqixuan.common.utils.StringUtil;

/**
 * @ClassName: ReadTest
 * @Description: TODO
 * @author: 常琪宣
 * @date: 2019年10月14日 上午8:49:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class ReadTest {

	@SuppressWarnings("rawtypes")
	@Autowired
	RedisTemplate redisTemplate;

	@SuppressWarnings({ "resource", "unchecked" })
	@Test
	public void listtest() throws Exception {
		File file = new File("D:/weektwo/week.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		for (int i = 0; i < 106; i++) {
			Goods goods = new Goods();
			String line = reader.readLine();
			String[] split = line.split("==");
			String id = split[0];
			String name = split[1];
			
			String[] prices =  split[2].split("¥");
			for (String price : prices) {
				goods.setPrice(price);
			}
			
			
			String[] bfbs = split[3].split("%");
			for (String bfb : bfbs) {
				goods.setBfb(bfb);
			}
			
			// isNumber()工具方法判断是不是数字
			boolean number = StringUtil.isNumber(id);

			// hasText()方法判断有没有值
			boolean hasText = StringUtil.hasText(split[3]);

			
			goods.setId(id);
			goods.setName(name);
			redisTemplate.opsForList().leftPush("goods_list", goods);
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void zsettest() throws Exception {
		File file = new File("D:/weektwo/week.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		for (int i = 0; i < 106; i++) {
			Goods goods = new Goods();
			String line = reader.readLine();
			String[] split = line.split("==");
			String id = split[0];
			String name = split[1];
			String[] prices =  split[2].split("¥");
			for (String price : prices) {
				goods.setPrice(price);
			}
			
			
			String[] bfbs = split[3].split("%");
			for (String bfb : bfbs) {
				goods.setBfb(bfb);
			}
			// isNumber()工具方法判断是不是数字
			boolean number = StringUtil.isNumber(id);

			// hasText()方法判断有没有值
			boolean hasText = StringUtil.hasText(split[3]);
			
			
			goods.setId(id);
			goods.setName(name);
			
			

			redisTemplate.opsForZSet().add("goods_zset", goods, i);
		}
	}
}
