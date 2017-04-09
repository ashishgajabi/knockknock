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
public class WordManipulationTest {
	
	@Autowired
	private WordManipulation wordManipulation;

	@Test
	public void testWordReversal() {		
		String result = wordManipulation.wordReversal("ABCDEFGH");
		assertEquals("HGFEDCBA", result);
	}
	
	@Test
	public void testNullWordReversal() {
		String result = wordManipulation.wordReversal(null);
		assertEquals("",result);
	}

	@Test
	public void testEmptyWordReversal() {
		String result = wordManipulation.wordReversal("");
		assertEquals("",result);
	}
	
}
