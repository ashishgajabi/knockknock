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
public class TriangleTypeTest {

	@Autowired
	private TriangleType triangleType;

	@Test
	public void testEquilateralTriangleType() {
		String result = triangleType.getTriangleType(4, 4, 4);
		assertEquals ("Equilateral", result);
	}
	
	@Test
	public void testIsoscelesTriangleType() {
		String result = triangleType.getTriangleType(4, 4, 7);
		assertEquals ("Isosceles", result);
	}
	
	
	@Test
	public void testScaleneTriangleType() {
		String result = triangleType.getTriangleType(4, 5, 6);
		assertEquals ("Scalene", result);
	}
	
	@Test
	public void testErrorTriangleType() {
		String result = triangleType.getTriangleType(400, 5, 6);
		assertEquals ("Error", result);
	}
	
	@Test
	public void testNegNumTriangleType() {
		String result = triangleType.getTriangleType(-4, 5, 6);
		assertEquals ("Error", result);
	}
	
	@Test
	public void testZeroNumTriangleType() {
		String result = triangleType.getTriangleType(0, 6, 6);
		assertEquals ("Error", result);
	}


}
