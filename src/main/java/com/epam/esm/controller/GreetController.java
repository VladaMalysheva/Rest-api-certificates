package com.epam.esm.controller;

import com.epam.esm.repository.entities.GiftCertificate;
import com.epam.esm.service.GiftCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetController {

    @Autowired
    private GiftCertificateService service;

    public GreetController(GiftCertificateService service) {
        this.service = service;
    }

    @GetMapping("/greet")
    public List<GiftCertificate> showview()
    {

//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("result.jsp");
//        mv.addObject("result",
//                "GeeksForGeeks Welcomes "
//                        + "you to Spring!");


        System.out.println(service.getById(1));
        return service.getAll();

    }
}
