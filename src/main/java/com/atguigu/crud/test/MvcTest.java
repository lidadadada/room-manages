package com.atguigu.crud.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:applicationContext.xml",
		"file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class MvcTest {
	//传入spring的ioc
	@Autowired
	WebApplicationContext context;
	//虚拟mvc请求
	MockMvc mockMvc;
	@Before
	public void initMockMvc() {
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception {
		System.out.println("当前页码-----------------------：");
		//模拟请求得到返回值
		MvcResult MvcResult = mockMvc.perform(MockMvcRequestBuilders
				.get("/book")
				
				.param("pn", "11"))
		.andReturn();
		//从请求域中获得数据
		MockHttpServletRequest request= MvcResult.getRequest();
		PageInfo attribute = (PageInfo) request.getAttribute("pageInfo");
		System.out.println("当前页码-----------------------："+attribute.getPageNum());
		System.out.println("总记录数："+attribute.getTotal());
		//获取连续分页值
		int[] nums = attribute.getNavigatepageNums();
		for ( int i : nums) {
			System.out.println(""+i);
		}
		
		
	}
}