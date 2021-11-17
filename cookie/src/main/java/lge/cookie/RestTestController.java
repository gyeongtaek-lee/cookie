package lge.cookie;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {

	@RequestMapping(value = "/hellospring", method = RequestMethod.GET)
	public String helloSpring() {
		return "Hello Spring";
	}
	
}
