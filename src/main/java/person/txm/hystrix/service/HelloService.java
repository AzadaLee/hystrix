package person.txm.hystrix.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="hellFallBack")
	public Object helloService(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("req1", "val1");
		params.put("req2", "val2");
		
		Map<String, Object> result = restTemplate.postForObject("http://producter/test/hello", params, Map.class);
		return result;
	}
	
	public String hellFallBack(){
		return "error";
	}
}
