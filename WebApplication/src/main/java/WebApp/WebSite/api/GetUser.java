package WebApp.WebSite.api;

import WebApp.WebSite.models.Person;
import WebApp.WebSite.repo.PersonRepo;
import WebApp.WebSite.security.AES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.util.HashMap;
import java.util.Map;

/*
 * @author h0riz4n m1d1
 */
@RestController
@RequestMapping("/getUser")
public class GetUser
{
    @Autowired
    private PersonRepo personRepo;

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, String> getUserAPI(@RequestParam("id") String id) throws IllegalBlockSizeException, BadPaddingException
    {
        long tgid = Long.valueOf(id).longValue();
        HashMap<String, String> map = new HashMap<>();

        if (personRepo.existsByTgid(tgid)) {
            Person person = personRepo.getByTgid(tgid);
            map.put("login", person.getLogin());
            map.put("tgId", String.valueOf(person.getTgid()));
            map.put("password", AES.decrypt(person.getPassword()));
            map.put("status", "true");
            return map;
        } else {
            map.put("status", "false");
            return map;
        }
    }
}
