package de.htwberlin.Webtechnologien;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

/*  @GetMapping(path = "/")
    public String showHelloWorldPage(Model model){
        model.addAttribute("helloName","Hello Yafes");
        return "HelloWorld"; //html Datei Name als Return --> falls in einem weiteren Ordner --> "Ordnername/Filename"
    } */

    @GetMapping(path = "/")
    public ModelAndView showHelloWorld() {
        return new ModelAndView("HelloWorld");
    }

}
