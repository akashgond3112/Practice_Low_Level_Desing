package com.java.lld.design.model.split;

import lombok.Getter;
import lombok.Setter;
import com.java.lld.design.model.User;

@Getter
@Setter
public abstract class Split {
    private User user;
    protected double amount;

    protected Split(User user) {
        this.user = user;
    }
}
