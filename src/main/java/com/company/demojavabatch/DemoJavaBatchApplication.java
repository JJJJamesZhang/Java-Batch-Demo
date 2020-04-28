package com.company.demojavabatch;

import com.company.demojavabatch.utils.CacheClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import redis.clients.jedis.JedisPool;

@SpringBootApplication
@ServletComponentScan
public class DemoJavaBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJavaBatchApplication.class, args);
	}
}
