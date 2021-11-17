package lge.cookie.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/test")
	public String getTest() {
		return "test";
	}
	
	@GetMapping("/")
	public String getIndexPage(HttpServletRequest request, Model model) {
		return "index";
	}
	
}
