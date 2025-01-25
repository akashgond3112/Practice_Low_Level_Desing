package com.java.design.patterns.models;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public abstract class LRUCache {
	Deque<String> dq;
	HashSet<String> map;
	int capacity;

	protected LRUCache(int n) {
		dq = new LinkedList<>();
		map = new HashSet<>();
		capacity = n;
	}

	public boolean read(String val) {
		if (!map.contains(val)) {
			return false;
		} else {
			int index = 0, i = 0;
			for (String s : dq) {
				if (s == val) {
					index = i;
					break;
				}
				i++;
			}
			dq.remove(index);
			dq.push(val);
			return true;
		}
	}

	public boolean write(String val) {
		boolean returnVal = false;
		if (!map.contains(val)) {
			if (dq.size() == capacity) {
				String last = dq.removeLast();
				map.remove(last);
			}
			returnVal = true;
		} else {
			int index = 0, i = 0;
			for (String s : dq) {
				if (s == val) {
					index = i;
					break;
				}
				i++;
			}
			dq.remove(index);
		}
		dq.push(val);
		map.add(val);
		return returnVal;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getFilledSize() {
		return map.size();
	}
}