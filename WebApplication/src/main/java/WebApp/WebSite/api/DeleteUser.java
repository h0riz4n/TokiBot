package WebApp.WebSite.api;

import WebApp.WebSite.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/deleteUser")
public class DeleteUser
{
    @Autowired
    PersonRepo personRepo;

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, String> deleteUserAPI(@RequestParam("id") long id) {
        long tgid = Long.valueOf(id).longValue();
        HashMap<String, String> map = new HashMap<>();


        if (personRepo.existsByTgid(tgid)) {
            personRepo.deleteByTgid(tgid);
            map.put("message", "Your profile has been deleted");
            return map;
        } else {
            map.put("message", "Sorry, but we don't have your account");
            return map;
        }
    }
}
