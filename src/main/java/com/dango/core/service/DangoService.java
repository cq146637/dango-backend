package com.dango.core.service;

import com.dango.common.exception.DangoException;
import com.dango.common.pojo.vo.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DangoService {

    public List<Person> listPerson() {
        Person person1 = Person.builder()
                .name("CQ")
                .age(21)
                .sex("男")
                .build();
        Person person2 = Person.builder()
                .name("CQ2")
                .age(22)
                .sex("女")
                .build();
        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        return list;
    }

    public Person findPersonByName(String name) {
        Person person1 = Person.builder()
                .name("CQ")
                .age(21)
                .sex("男")
                .build();
        Person person2 = Person.builder()
                .name("CQ2")
                .age(22)
                .sex("女")
                .build();
        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);

        for(Person person: list) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new DangoException("查无此人！");
    }
}
