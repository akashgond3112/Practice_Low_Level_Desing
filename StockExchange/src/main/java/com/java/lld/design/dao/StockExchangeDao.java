package com.java.lld.design.dao;

import com.java.lld.design.model.BuyOrder;
import com.java.lld.design.model.SellOrder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Objects;
import java.util.PriorityQueue;

/*
This Dao maintains the Sell order in the queue based on the comparator
 */
public class StockExchangeDao {

    @Getter
	private final PriorityQueue<SellOrder> sellOrderPriorityQueue = new PriorityQueue<>((o1, o2) -> {
		// if same price return the more quantity
		if (Objects.equals(o1.getPrice(), o2.getPrice())) {
			return o2.getQuantity() - o1.getQuantity();
		}
		return Double.compare(o1.getPrice(), o2.getPrice());
	});

    private final ArrayList<BuyOrder> executedBuyOrder = new ArrayList<>();

	public void addSellOrder(SellOrder order) {
        sellOrderPriorityQueue.add(order);
    }

    private void addCompletedOrder(BuyOrder order) {
        executedBuyOrder.add(order);
    }

}
