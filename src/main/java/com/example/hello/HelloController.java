package com.example.hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@GetMapping(path = "/hello2")
    public ResponseEntity<Message> hello2() {
        Message message = new Message("hello-dx-2");
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

	@GetMapping(path = "/graceful20")
	public Map<String, String> graceful20() throws InterruptedException {
		Map<String, String> map = new HashMap<>();
		map.put("message", "graceful20");
		Thread.sleep(20_000L);
		return map;
	}

	@GetMapping(path = "/graceful30")
	public Map<String, String> graceful30() throws InterruptedException {
		Map<String, String> map = new HashMap<>();
		map.put("message", "graceful30");
		Thread.sleep(30_000L);
		return map;
	}

	@GetMapping(path = "/graceful40")
	public Map<String, String> graceful40() throws InterruptedException {
		Map<String, String> map = new HashMap<>();
		map.put("message", "graceful40");
		Thread.sleep(40_000L);
		return map;
	}

}
