package com.java.lld.design.model.expense;


import com.java.lld.design.model.split.PercentSplit;
import com.java.lld.design.model.split.Split;
import com.java.lld.design.model.User;

import java.util.List;

public class PercentExpense extends Expense {
	public PercentExpense(double amount, User paidBy, List<Split> splits) {
		super(amount, paidBy, splits);
	}

	@Override
	public boolean validate() {
		for (Split split : getSplits()) {
			if (!(split instanceof PercentSplit))
				return false;
		}

		double totalPercent = 0;
		double sumSplitPercent = 0;

		for (Split split : getSplits()) {
			PercentSplit percentSplit = (PercentSplit) split;
			sumSplitPercent += percentSplit.getPercent();
		}

		if (totalPercent != sumSplitPercent)
			return false;

		return true;
	}
}
