package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@Slf4j
public class RequestParamController {

    @ResponseBody // class의 애노테이션이 @Controller 인데 해당 매서드의 return 값을 String으로 할 경우
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@RequestParam("username") String username, @RequestParam("age") int age){
        HelloData hellodata = new HelloData();
        hellodata.setUsername(username);
        hellodata.setAge(age);

        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    @ResponseBody // class의 애노테이션이 @Controller 인데 해당 매서드의 return 값을 String으로 할 경우
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(@ModelAttribute HelloData hellodata){
        

        log.info("username ={}, age = {}", hellodata.getUsername(), hellodata.getAge());
        return "ok";
    }
}
