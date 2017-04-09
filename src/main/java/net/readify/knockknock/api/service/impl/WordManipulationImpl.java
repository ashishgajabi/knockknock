package net.readify.knockknock.api.service.impl;

import org.springframework.stereotype.Service;

import net.readify.knockknock.api.service.WordManipulation;

/**
 * @author Ashish Gajabi
 * This service is for word maniputlation like word reversal 
 */
@Service
public class WordManipulationImpl implements WordManipulation {

	@Override
	public String wordReversal(String word) {
		if (word == null || word.equals("")){
			return "";
		}
		return (new StringBuilder(word)).reverse().toString();
	}

}
