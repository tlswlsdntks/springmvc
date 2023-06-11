package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class RequestParamController {

    // localhost:8080/request-param-v1?username=1&age=2
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        // String 타입의 숫자를 int 타입으로 변환
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("requestParamV1 username={}", username);
        log.info("requestParamV1 age={}", age);

        response.getWriter().write("ok");
    }

    // localhost:8080/request-param-v2?username=1&age=2
    @RequestMapping("/request-param-v2")
    @ResponseBody
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge){

        log.info("userName={}, age={}", memberName, memberAge);

        return "ok";
    }

    // localhost:8080/request-param-v3?username=1&age=2
    @RequestMapping("/request-param-v3")
    @ResponseBody
    public String requestParamV3 (
        @RequestParam String username,
        @RequestParam int age){
        log.info("userName={}, age={}", username, age);
        return "ok";
    }

}