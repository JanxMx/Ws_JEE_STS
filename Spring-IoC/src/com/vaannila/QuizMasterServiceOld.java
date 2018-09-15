package com.vaannila;

public class QuizMasterServiceOld {
	private QuizMaster quizMaster = new SpringQuizMaster();
	
	public void askQuestion() {
		System.out.println(quizMaster.popQuestion());
	}
}
