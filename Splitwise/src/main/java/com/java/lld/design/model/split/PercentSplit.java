package com.java.lld.design.model.split;

import lombok.Getter;
import lombok.Setter;
import com.java.lld.design.model.User;

@Getter
@Setter
public class PercentSplit extends Split {
	private double percent;

	public PercentSplit(User user, double percent) {
		super(user);
		this.percent = percent;
	}
}
