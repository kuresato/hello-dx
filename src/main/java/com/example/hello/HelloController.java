package com.example.hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;
import java.util.HashMap;

@RestController
public class HelloController {

	@GetMapping(path = "/")
	public Map<String, String> index() {
		Map<String, String> map = new HashMap<>();
		map.put("message", "hello-dx");
		return map;
	}

}
