package spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import spring.boot.dao.UserRepository;
import spring.boot.models.Users;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
public class UsersController {

    @Autowired
    private UserRepository userRepository;


    public String homeUser(Model model){
        String message = "Bienvenue";
        model.addAttribute("theMessage", message);
        return "index";
    }

    @GetMapping(value = "/listeUtilisateurs")
    public String getAllUsers(Model model){
        Iterable<Users> users = new ArrayList<>();
        users = userRepository.findAll();
        model.addAttribute("users",users);

        return "usersLists";
    }
}
