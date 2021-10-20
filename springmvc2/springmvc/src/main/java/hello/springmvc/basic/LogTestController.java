package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
//    private final Logger log  = LoggerFactory.getLogger(LogTestController.class);  ==> @Slf4J로 대체 가능

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name =" + name);

        log.trace("trace log = {}", name);  // application.properties 파일에서 log의 레벨을 정할 수 있음
        log.debug("debug log= {}", name);
        log.info("info log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log = {}", name);

        return "ok";

    }
}
