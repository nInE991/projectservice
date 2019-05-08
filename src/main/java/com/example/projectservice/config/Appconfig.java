package com.example.projectservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Appconfig {
	@Bean
	public List<String> roleList() {
		var list = new ArrayList<String>();
		list.add("Администратор");
		list.add("Директор");
		list.add("Менеджер");
		list.add("Сотрудник ремонта");
		return list;
	}
}
