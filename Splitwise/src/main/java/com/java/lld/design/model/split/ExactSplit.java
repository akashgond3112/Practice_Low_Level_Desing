package com.java.lld.design.model.split;

import com.java.lld.design.model.User;

public class ExactSplit extends Split {
	public ExactSplit(User user, double amount) {
		super(user);
		this.amount = amount;
	}
}
