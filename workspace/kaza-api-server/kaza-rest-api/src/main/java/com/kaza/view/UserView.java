package com.kaza.view;

import com.kaza.pojo.Pojo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciel on 30/09/2016.
 */
@RestController
public class UserView {


    @RequestMapping("/any/endpoint")
    public String anyEndpoint(@RequestParam(name = "param", required = false) String param) {
        return String.join(" ", "Este eh um endpoint", param);
    }

    @RequestMapping("/other/{email}/endpoint")
    public List<Pojo> otherEndpoint(@RequestParam(name = "param", required = false) String param,
                                    @PathVariable(value = "email") String email) {
        System.out.println("Email: " +  email);

        List<Pojo> pojos = new ArrayList<>();
        pojos.add(Pojo.builder().str("pojo 1").build());
        pojos.add(Pojo.builder().str("pojo 2").build());
        pojos.add(Pojo.builder().str("pojo 3").build());

        return pojos;
    }

}
