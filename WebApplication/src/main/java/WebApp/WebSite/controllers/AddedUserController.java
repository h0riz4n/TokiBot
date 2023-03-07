package WebApp.WebSite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @author h0riz4n m1d1
 */
@Controller
public class AddedUserController
{
    @RequestMapping("/addedUser")
    public String addedUser()
    {
        return "registered";
    }
}
