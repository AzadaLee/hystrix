package person.txm.hystrix.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import person.txm.hystrix.service.HelloService;

@RestController
@RequestMapping("/hystrix")
public class HelloController {

	@Autowired
	private HelloService helloService;
	
	@RequestMapping("/hello")
	public Object hello(){
		return helloService.helloService(); 
	}
}
