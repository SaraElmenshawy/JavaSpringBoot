package com.springboot.first.app;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.app.dto.Variable;

@RestController
public class HelloWorldController {

	@RequestMapping(value="/GoogleSearch1",method = RequestMethod.GET )
	public String getSearchResults2()
	{
		return "hello sara";
	}
	@RequestMapping(value="/GoogleSearch",method = RequestMethod.POST, consumes="application/json")
	public String getSearchResults(@RequestBody Variable variable)
	{
		return "hello"+variable.getKeyword();
	}
}
