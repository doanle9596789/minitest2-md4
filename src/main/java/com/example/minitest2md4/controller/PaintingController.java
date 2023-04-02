package com.example.minitest2md4.controller;

import com.example.minitest2md4.model.Painting;
import com.example.minitest2md4.service.Painting.IPaintingService;
import com.example.minitest2md4.service.Painting.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaintingController {
    @Autowired
   private IPaintingService paintingService;
    @GetMapping("/painting")
    public ModelAndView listCustomers() {
        Iterable<Painting>paintings=paintingService.findAll();
        ModelAndView modelAndView=new ModelAndView("/list");
        modelAndView.addObject("paintings",paintings);
        return modelAndView;
    }


}

