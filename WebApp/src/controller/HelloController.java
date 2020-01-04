package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping(value = "another")
    public ModelAndView hello() {
        System.out.println("hello springmvc...");
        ModelAndView mav = new ModelAndView();
        //设置模型数据，用于传递到jsp页面中显示
        mav.addObject("msg", "hello springmvc......");
        //设置视图名字，用于响应用户
        mav.setViewName("one");
        return mav;
    }
}
