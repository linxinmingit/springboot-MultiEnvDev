package cn.yr.datasources.demodatasources.jta;

import cn.yr.datasources.demodatasources.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonControllerJta {

    @Autowired
    private PersonServiceJta personServiceJta;

    @RequestMapping("/test")
    public String save()
    {
        personServiceJta.insert();
        return "successful";
    }
}
