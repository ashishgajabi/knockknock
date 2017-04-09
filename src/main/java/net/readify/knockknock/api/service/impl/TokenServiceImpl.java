package net.readify.knockknock.api.service.impl;

import org.springframework.stereotype.Service;

import net.readify.knockknock.api.service.TokenService;

/**
 * @author Ashish Gajabi
 * THis service returns hard coded token
 */
@Service
public class TokenServiceImpl implements TokenService {

	private static final String selfTOekn = "abc7d48e-e529-4b46-8749-7886c0359e3a";
	
	@Override
	public String getSelfToken() {
		return selfTOekn;
	}

}
