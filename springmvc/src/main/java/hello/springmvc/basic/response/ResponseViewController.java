package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    // localhost:8080/response/response-view-v1
    // -> templates/response/hello.html
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "responseViewV1!");

        return mav;
    }

    // localhost:8080/response/response-view-v2
    // -> templates/response/hello.html
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "responseViewV2!");

        return "response/hello";
    }

    // localhost:8080/response/response/hello
    // -> templates/response/hello.html
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "response/hello!");
    }
}
