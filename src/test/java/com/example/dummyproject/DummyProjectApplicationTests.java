package com.example.dummyproject;

import com.example.dummyproject.common.CommonClass;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class DummyProjectApplicationTests {
@Autowired
	CommonClass commonClass;
	private ObjectMapper mapper = new ObjectMapper();

	@Test
	void contextLoads() {

		System.out.println(UUID.randomUUID().toString().replace("-","_"));


	}
}


