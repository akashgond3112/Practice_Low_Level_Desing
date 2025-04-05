package com.java.lld.design.model.expense;

import com.java.lld.design.model.split.EqualSplit;
import com.java.lld.design.model.split.Split;
import com.java.lld.design.model.User;

import java.util.List;

public class EqualExpense extends Expense{
    public EqualExpense(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        for(Split split: getSplits()){
            if( !(split instanceof EqualSplit))
                return false;
        }

        return true;
    }
}
