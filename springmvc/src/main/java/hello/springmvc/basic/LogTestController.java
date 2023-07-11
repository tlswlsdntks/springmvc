package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // @Component
public class LogTestController {

//     private final Logger log = LoggerFactory.getLogger(getClass());
//     private final Logger log = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";
        System.out.println("name = " + name);

        /**
         *  logger.trace() 메소드가 실행되기 전에
         *  " trace my log=" + name 이라는 문자열 연산이 먼저 일어나서
         *  문자열 연산만큼의 성능 악화가 발생된다.
         */
        // log.trace(" trace my log=" + name);

        // 로그 레벨 순서
        // TRACE > DEBUG > INFO > WARN > ERROR
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }

}
