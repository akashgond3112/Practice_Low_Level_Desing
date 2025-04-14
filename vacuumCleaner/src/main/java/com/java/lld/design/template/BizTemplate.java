package com.java.lld.design.template;

import java.util.HashMap;
import java.util.Map;

public class BizTemplate {


	public <T, R> R execute(final T request, final BizBaseCallback<T, R> action) {

		long startTime = System.currentTimeMillis();

		final Map<Object, Object> container = new HashMap<Object, Object>();

		final R result = action.createDefaultResult();

		try {

			action.preProcess(request, result, container);

			action.process(request, result, container);

			action.bizPostProcess(request, result, container);

		} catch (Exception ex) {


		} finally {
		}

		return result;
	}

}