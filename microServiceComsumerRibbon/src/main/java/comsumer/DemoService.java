package comsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoService {
    @Autowired
    private RestTemplate restTemplate;

    public String service(){
        return restTemplate.getForObject("http://microservice-provider-demo/say",
                String.class);
    }
}
