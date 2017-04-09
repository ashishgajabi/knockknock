package net.readify.knockknock.api.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.readify.knockknock.api.config.SpringAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringAppConfiguration.class})
public class FibonacciServiceTest {
	
	@Autowired
	private FibonacciService fibonacciService;

	@Test
	public void testGetNthFibonacciNum() {
		String result = fibonacciService.getNthFibonacciNum(5);
		assertEquals("5", result);
	}

	@Test
	public void test93rdFibonacciNum() {
		String result = fibonacciService.getNthFibonacciNum(93);
		assertEquals(null, result);
	}
	
	@Test
	public void testNeg93rdFibonacciNum() {
		String result = fibonacciService.getNthFibonacciNum(-93);
		assertEquals(null, result);
	}
	
	@Test
	public void testNegFibonacciNum() {
		String result = fibonacciService.getNthFibonacciNum(-6);
		assertEquals("-8", result);
	}
	
	@Test
	public void testGet0thFibonacciNum() {
		String result = fibonacciService.getNthFibonacciNum(0);
		assertEquals("0", result);
	}
	
	@Test
	public void testGet22thFibonacciNum() {
		String result = fibonacciService.getNthFibonacciNum(22);
		assertEquals("17711", result);
	}
	
	@Test
	public void testGet100000000thFibonacciNum() {
		String result = fibonacciService.getNthFibonacciNum(100000000);
		assertEquals(null, result);
	}
}
