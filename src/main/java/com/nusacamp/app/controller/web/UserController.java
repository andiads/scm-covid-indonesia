package com.nusacamp.app.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class UserController {
	//@GetMapping("/users")
	public String list() {
		return "users";
	}
}
