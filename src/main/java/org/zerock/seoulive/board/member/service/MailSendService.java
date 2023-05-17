package org.zerock.seoulive.board.member.service;

public interface MailSendService {
	public abstract void makeRandomNumber();
	public abstract String joinEmail(String email);
	public abstract void mailSend(String setFrom, String toMail, String title, String content);
}	// end interface 
