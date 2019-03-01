package com.atguigu.crud.test;

import java.net.URLEncoder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml" })
public class MvcTest {
	// 传入spring的ioc
	@Autowired
	WebApplicationContext context;
	// 虚拟mvc请求
	MockMvc mockMvc;

	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testPagess() throws Exception {
		System.out.println("当前页码-----------------------：");
		// 模拟请求得到返回值
		MvcResult MvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/head/get/2019_03_01_08_00_00_"+URLEncoder.encode("1116房间")))
				.andReturn();

		// 从请求域中获得数据
		/*
		 * MockHttpServletRequest request= MvcResult.getRequest(); PageInfo attribute =
		 * (PageInfo) request.getAttribute("list");
		 * System.out.println("当前页码-----------------------："+attribute.getPageNum());
		 * System.out.println("总记录数："+attribute.getTotal()); //获取连续分页值 int[] nums =
		 * attribute.getNavigatepageNums(); for ( int i : nums) {
		 * System.out.println(""+i); }
		 */

	}
}