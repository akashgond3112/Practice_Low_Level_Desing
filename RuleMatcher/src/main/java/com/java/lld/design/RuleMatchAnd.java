package com.java.lld.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RuleMatchAnd implements Rule {

    List<Rule> list = new ArrayList<>();

    public RuleMatchAnd(Rule ... rules) {
		Collections.addAll(list, rules);
    }

    @Override
    public boolean match(Item item) {
        for (Rule r : list){
            if(r.match(item)){
                return  false;
            }
        }
        return true;
    }
}
