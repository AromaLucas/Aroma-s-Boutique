package com.niit.ABBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		System.out.println("Success");

	}

}
