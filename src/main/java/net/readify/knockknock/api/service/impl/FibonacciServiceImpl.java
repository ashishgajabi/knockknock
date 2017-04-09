package net.readify.knockknock.api.service.impl;

import org.springframework.stereotype.Service;

import net.readify.knockknock.api.service.FibonacciService;

/**
 * @author Ashish Gajabi
 * Service Class method to generate fibonacci series
 */
@Service
public class FibonacciServiceImpl implements FibonacciService {

	@Override
	public final String getNthFibonacciNum(int n) {
		
		boolean isNegativeFibonacci = false;
		
		if (n == 0) 
		{
			return "" + 0;
		}
		else if (n < 0)
		{
			isNegativeFibonacci = true;
			n = n * -1;
		}

		long num = 0;
		long num2 = 1;
		long fibonacci = 0;

		for (int loop = 0; loop < n; loop++) 
		{
			fibonacci = num + num2;
			if (num2 < 0) 
			{
				return null;
			}
			num = num2;
			num2 = fibonacci;
		}

		if (isNegativeFibonacci) 
		{
			num = (n % 2 == 0) ? -num : num;
		}
		return "" + num;
	}

}
