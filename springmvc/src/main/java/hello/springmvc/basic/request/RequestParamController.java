package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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

    // localhost:8080/request-param-v4?username=1&age=2
    @RequestMapping("/request-param-v4")
    @ResponseBody
    public String requestParamV4 (String username, int age){
        log.info("userName={}, age={}", username, age);
        return "ok";
    }

    // localhost:8080/request-param-required?username=id&age=2
    // localhost:8080/request-param-required?username=id&age=, 에러 발생
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired (
            @RequestParam(required = true) String username,
            @RequestParam(required = false) int age){

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    // localhost:8080/request-param-required?username=id&age=2
    // localhost:8080/request-param-required?username=id&age=
    // age= -> Integer age는 null 가능이므로 에러가 발생하지않는다
    @ResponseBody
    @RequestMapping("/request-param-required2")
    public String requestParamRequired2 (
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age){

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    // localhost:8080/request-param-default
    // localhost:8080/request-param-default?username=&age=
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault (
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") int age){

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    // localhost:8080/request-param-map?username=id&age=1
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    // localhost:8080/request-attribute-v1?username=id&age=1
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    // localhost:8080/request-attribute-v2?username=id&age=1
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

}