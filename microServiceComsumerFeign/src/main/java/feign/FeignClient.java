package feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@org.springframework.cloud.openfeign.FeignClient(value = "microservice-provider-demo",
        configuration = FeignConfig.class)
public interface FeignClient {

    /**
     * @FeignClient注解来声明一个Feign Client。value为远程调用其他服务的服务名，
     * FeignConfig.class为配置类，在EurekaClientFeign内部有一个sayHiFromClientEureka()的方法，
     * 该方法通过Feign来调用microservice-provider-demo服务的“/say”的aipi接口。
     * 如果方法有参数，可以参考这种写法，下面实例是没有参数
     *   @GetMapping(value = "/say")
     *     String sayHiFromClientEureka(@RequestParam(value = "name")String name);
     */
    @GetMapping(value = "/say")
    String sayHiFromClientEureka();
}
