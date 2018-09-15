/**
 * Inversion of Control (IoC) / Dependency Injection
 * It's a process for instanciate objects instead of use the new keyword
 */

package com.vaannila;

public class QuizMasterService {

	// IoC / Dependency Injection
	QuizMaster quizMaster;
	
	public void setQuizMaster(QuizMaster quizMaster) {
		this.quizMaster = quizMaster;
	}
	
	public void askQuestion() {
		System.out.println(quizMaster.popQuestion());
	}
}
