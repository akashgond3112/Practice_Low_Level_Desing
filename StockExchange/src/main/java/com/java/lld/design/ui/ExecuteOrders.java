package com.java.lld.design.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecuteOrders {
	private static final Logger log = LoggerFactory.getLogger(ExecuteOrders.class);

	public void executeOrders(String buyOrderId, Double sellingPrice, int quantity, String sellerOrderID) {
		log.info("{} {} {} {}", buyOrderId, sellingPrice, quantity, sellerOrderID);
    }
}
