package com.novacloud.data.formula.impl.test;


import java.io.IOException;

import com.novacloud.data.formula.json.JSONDecoder;
import com.novacloud.data.formula.json.JSONEncoder;
import com.novacloud.data.formula.impl.ExpressionFactoryImpl;

public class ExpressionParseTimelTest {
	private final ExpressionFactoryImpl factory = new ExpressionFactoryImpl();

	public static void main(String[] args) throws Exception {
		new ExpressionParseTimelTest().testELTime();
	}
	public void testELTime() throws IOException {
		test("\"123\"");
		test("123444");
		test("sss[123444]");
		test("aaa[1][2][\"123\"]");
		test("aaa.bb.cc.dd");
		test("aaa+ddd(1)+asd.cc(1,2,3)");
	}

	private void test(String el) {
		Object els = factory.parse(el);
		final String jsonel = JSONEncoder.encode(els);
		int count = 1000,count2;
		long t1 = 0, t2 = 0;
		while (count-- > 0) {
			long m1 = System.currentTimeMillis();
			count2 = 100;
			while (count2-- > 0) {
				factory.create(el);
			}
			long m2 = System.currentTimeMillis();
			count2 = 100;
			while (count2-- > 0) {
				factory.create(JSONDecoder.decode(jsonel));
			}
			long m3 = System.currentTimeMillis();
			t1 += m2 - m1;
			t2 = m3 - m2;
		}
		System.out.println(el);
		System.out.println(jsonel);
		System.out.println("el:"+t1);
		System.out.println("jsonel:"+t2);
		System.out.println();

	}

}
