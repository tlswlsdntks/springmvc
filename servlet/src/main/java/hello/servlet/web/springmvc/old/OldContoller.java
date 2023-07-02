package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HandlerMapping: BeanNameUrlHandlerMapping
 * HandlerAdapter: SimpleControllerHandlerAdapter
 */
@Component("/springmvc/old-controller")
public class OldContoller implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldContoller.handleRequest");
        return new ModelAndView("new-form");
    }
}
