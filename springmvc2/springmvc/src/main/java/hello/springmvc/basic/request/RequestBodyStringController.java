package hello.springmvc.basic.request;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {
    @PostMapping("/request-body-string-v1")
    public void requestBodyString(HttpServletRequest request,
                                  HttpServletResponse response) throws IOException {

        ServletInputStream inputStream = request.getInputStream();       //InputStream으로 메시지를 가져와서
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);     // UTF-8 설정
        log.info("messageBody={}", messageBody);
        response.getWriter().write("ok");
    }

    @PostMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer responseWriter)
            throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream,
                StandardCharsets.UTF_8);
        log.info("messageBody={}", messageBody);
        responseWriter.write("ok");
    }

    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) {
        String messageBody = httpEntity.getBody();
        log.info("messageBody={}", messageBody);
        return new HttpEntity<>("ok");
    }

    @ResponseBody   // @ResponseBody 를 사용하면 응답 결과를 HTTP 메시지 바디에 직접 담아서 전달할 수 있다. , 이 경우도 view를 사용하지 않는다.
    @PostMapping("/request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String messageBody) {        // 을 @RequestBody가 대신 해준다.
        log.info("messageBody={}", messageBody);
        return "ok";
    }

}