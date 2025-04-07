package com.java.lld.design.model.expense;

import com.java.lld.design.model.split.Split;
import com.java.lld.design.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public abstract class Expense {
    private String id;
    private double amount;
    private User paidBy;
    private List<Split> splits;

    protected Expense(double amount, User paidBy, List<Split> splits) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
    }

    public abstract boolean validate();
}
