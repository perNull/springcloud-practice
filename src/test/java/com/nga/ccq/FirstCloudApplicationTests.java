package com.nga.ccq;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.nga.ccq.controller.HelloController;

// SpringRunner extends SpringJUnit4ClassRunner
@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstCloudApplicationTests {
	
	// 用于模拟调用Controller的接口发起请求 ，perform()之前一次模拟请求，accept()用于执行接收的数据类型
	// andExpect用于判断接口返回的期望值
	private MockMvc mok;
	
	@Before //在test之前执行
	public void setUp() {
		mok = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}

	@Test
	public void inex() throws Exception {
		mok.perform(MockMvcRequestBuilders.get("/index").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(content().string(equalTo("hello")));
	}

}
