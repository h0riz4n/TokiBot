package WebApp.WebSite.controllers;

import WebApp.WebSite.models.Person;
import WebApp.WebSite.repo.PersonRepo;
import WebApp.WebSite.toki_api.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import WebApp.WebSite.utils.Utils;

/*
 * @author h0riz4n m1d1
 */
@Controller
public class RegistrationController
{
    @Autowired
    private PersonRepo personRepo;

    /*
        Adding user in db if his data are valid
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String addUser(Model model, @PathVariable("id") long id, @RequestParam("login") String login, @RequestParam("password") String password) {
        if (Utils.validData(login, password)) {
            personRepo.save(new Person(login, password, id));
            try {
                Bot.sendSticker(id);
                Bot.sendMessage(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "forward:/addedUser";
        } else {
            return "index";
        }
    }

    /*
        Chek user in db and gives him html page
     */
    @GetMapping("/{id}")
    public String registrationMapping(Model model, @PathVariable("id") long id) {
        if (personRepo.existsByTgid(id)) {
            return "registered";
        } else {
            return "index";
        }
    }
}
