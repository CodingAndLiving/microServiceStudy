package comsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallBack")
    public String service(){
        return restTemplate.getForObject("http://microservice-provider-demo/say",
                String.class);
    }

    public String fallBack(){
        return "hello ,this is fallBack method";
    }
}
