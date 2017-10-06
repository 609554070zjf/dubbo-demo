/**
 * 
 */
package edu.fjnu.cse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Javon
 *
 */
@Controller
public class MyController {
	
	@Autowired
	private TestRegistryService testRegistryService;
	
	
	@RequestMapping(value="/test")
	@ResponseBody
	public String testHello(@RequestParam(value="name",defaultValue="") String name){
		StringBuffer sb = new StringBuffer();
		sb.append("Dubbo: ").append(testRegistryService.hello(name));
		return sb.toString();
	}
	
}
