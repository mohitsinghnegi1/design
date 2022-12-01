package com.glarimy.adapter;

import java.util.Date;

public class Component {

	public void process() {
		System.out.println(new Date() + " - " + this.getClass().getName() + "::execute()");
	}

}
