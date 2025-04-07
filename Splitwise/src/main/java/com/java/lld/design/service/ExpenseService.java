package com.java.lld.design.service;


import com.java.lld.design.model.expense.EqualExpense;
import com.java.lld.design.model.expense.ExactExpense;
import com.java.lld.design.model.expense.Expense;
import com.java.lld.design.model.expense.PercentExpense;
import com.java.lld.design.model.ExpenseType;
import com.java.lld.design.model.split.PercentSplit;
import com.java.lld.design.model.split.Split;
import com.java.lld.design.model.User;

import java.util.List;

public class ExpenseService {
    public static Expense createExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits){
        switch (expenseType){
            case EXACT:
                return new ExactExpense(amount, paidBy, splits);
            case EQUAL:
                int totalSplitSize= splits.size();
                double splitAmount= Math.round(amount*100/totalSplitSize)/100.0;
                for(Split split: splits){
                    split.setAmount(splitAmount);
                }

                splits.get(0).setAmount(splitAmount + amount - splitAmount*totalSplitSize);
                return new EqualExpense(amount, paidBy, splits);
            case PERCENT:
                for(Split split: splits){
                    PercentSplit percentSplit= (PercentSplit) split;
                    split.setAmount((amount * percentSplit.getPercent())/100.0);
                }
                return new PercentExpense(amount, paidBy, splits);
        }

        return null;
    }
}
