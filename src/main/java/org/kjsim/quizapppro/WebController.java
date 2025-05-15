package org.kjsim.quizapppro;

import org.hibernate.annotations.ConcreteProxy;
import org.springframework.web.bind.annotation.RequestMapping;

@ConcreteProxy
public class WebController {
    @RequestMapping({"/", "home"})
    public String viewHome() {
        return "index";
    }

}
