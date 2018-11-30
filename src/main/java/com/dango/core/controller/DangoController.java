package com.dango.core.controller;

import com.dango.common.pojo.dto.Result;
import com.dango.common.pojo.vo.Person;
import com.dango.core.service.DangoService;
import com.dango.common.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class DangoController {

    @Autowired
    private DangoService dangoService;

    @RequestMapping("dango")
    public Result HelloWorld() {
        return ResultUtil.success("Hello, this is Dango!");
    }

    @GetMapping("person")
    public Result getPerson() {
        List<Person> peoples = dangoService.listPerson();
        return ResultUtil.success(peoples);
    }

    @GetMapping("persons")
    public Result findPersonByName(@RequestParam("name") String name) {
        Person person = dangoService.findPersonByName(name);
        return ResultUtil.success(person);
    }
}
