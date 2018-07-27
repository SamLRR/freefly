package io.khasang.freefly.controller;

import io.khasang.freefly.model.Message;
import io.khasang.freefly.model.call.Call;
import io.khasang.freefly.model.call.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//controller MVC
@Controller
//localhost: 8080/
public class AppController {


    @Value("Hello new Bean")
    private final Message message;
    private final Call callImpl;
    private final CreateTable createTable;

    @Autowired
    public AppController(Message message, Call callImpl, CreateTable createTable) {
        this.message = message;
        this.callImpl = callImpl;
        this.createTable = createTable;
    }

    @RequestMapping("/")
    public String getHelloPage(Model model) {
//        message=new Message("dffdfdds");
        model.addAttribute("message", message.getInfo());
        model.addAttribute("call", callImpl.getInfo());
        return "hello";
    }

    @RequestMapping("/create")
    public String createTableStatus(Model model) {
        model.addAttribute("status", createTable.create());
        return "create";
    }

    @RequestMapping("/admin")
    public String getSecurPage(Model model) {
        model.addAttribute("secure", "Very secure content!");
        return "secure";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/adm")
    public String getSecurPage2(Model model) {
        model.addAttribute("secure", "Very secure content!");
        return "secure";
    }

    @RequestMapping(value = "password/{password}",method = RequestMethod.GET)
    public String getCryptPassword(@PathVariable("password") String password, Model model){
        model.addAttribute("password",password);
        model.addAttribute("encodePassword",new BCryptPasswordEncoder().encode(password));
        return "password";
    }
}
