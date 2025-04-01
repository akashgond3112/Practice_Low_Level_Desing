package com.java.lld.design;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class RuleMatcherApplication {
	private static Category category;
	private static int i;

	public static void main(String[] args) {
        List<Item> result;
        Container container = new Container();
        Rule rule = new RuleMatchAnd(ruleMatchWeight(), ruleMatchCategory());
        result = RuleMatcher.findItemsMatchingRule(container,rule);
        for(Item item : result){
            log.info(item.getName());
        }
    }

    private static Rule ruleMatchCategory() {
		RuleMatcherApplication.category = Category.BOOKS;
		return null;
    }

    private static Rule ruleMatchWeight() {
		RuleMatcherApplication.i = 50;
		return null;
    }
}
