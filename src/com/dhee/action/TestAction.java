package com.dhee.action;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{

	
	public String test(){
		System.out.println("TestAction test()!");
		return SUCCESS;
	}
	
}
