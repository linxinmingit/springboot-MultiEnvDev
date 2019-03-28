package cn.yr.datasources.demodatasources.jta;

import cn.yr.datasources.demodatasources.interface1.PersonInterface1;
import cn.yr.datasources.demodatasources.interface2.PersonInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceJta {
    @Autowired
    private PersonInterface1 personInterface1;

    @Autowired
    private PersonInterface2 personInterface2;

    @Transactional
    public void insert()
    {
        Person person = new Person();
        person.setAddr("-----");
        person.setAge(100);
        person.setAddr("----------");


        //int c = 2/0;
        personInterface1.insert(person);
        personInterface2.insert(person);
    }
}
