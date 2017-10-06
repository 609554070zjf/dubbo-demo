/**
 * 
 */
package edu.fjnu.cse.service.impl;

import edu.fjnu.cse.service.TestRegistryService;

/**
 * @author Javon
 *
 */
public class TestRegistryServiceImpl implements TestRegistryService{

	@Override
	public String hello(String name) {
		return name + " say hello world!";
	}

}
