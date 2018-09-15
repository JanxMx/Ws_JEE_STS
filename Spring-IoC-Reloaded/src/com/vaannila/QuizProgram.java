package com.vaannila;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuizProgram {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		// Spring question
		QuizMasterService spQuizMasterService = (QuizMasterService) context.getBean("spQuizMasterService");
		spQuizMasterService.askQuestion();
		
		// Struts question
		QuizMasterService stQuizMasterService = (QuizMasterService) context.getBean("stQuizMasterService");
		stQuizMasterService.askQuestion();
	}
}
