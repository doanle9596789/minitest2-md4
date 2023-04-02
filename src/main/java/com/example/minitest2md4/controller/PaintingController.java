package com.example.minitest2md4.controller;

import com.example.minitest2md4.model.Category;
import com.example.minitest2md4.model.Painting;
import com.example.minitest2md4.repository.PaintingRepository;
import com.example.minitest2md4.service.Category.ICategoryService;
import com.example.minitest2md4.service.Painting.IPaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;
import java.util.Optional;

@Controller
public class PaintingController {
    @Autowired
   private IPaintingService paintingService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private PaintingRepository paintingRepository;
    @ModelAttribute("categoris")
    public Iterable<Category> categorys(){
        return categoryService.findAll();
    }
    @GetMapping("/paintings")
    public ModelAndView listCustomers() {
        Iterable<Painting>paintings=paintingService.findAll();
        ModelAndView modelAndView=new ModelAndView("/painting/list");
        modelAndView.addObject("paintings",paintings);
        return modelAndView;
    }
    @GetMapping("/create-painting")
    public ModelAndView showForm(){
        ModelAndView modelAndView=new ModelAndView("/painting/create");
        modelAndView.addObject("painting",new Painting());
        return modelAndView;
    } @PostMapping("/create-painting")
    public ModelAndView savePainting(@ModelAttribute("painting") Painting painting , BindingResult bindingResult) {
//        new Painting().validate(painting,bindingResult);
//        if (bindingResult.hasErrors()){
//            return new ModelAndView("/painting/create");
//        }

        ModelAndView modelAndView = new ModelAndView("/painting/create");
        modelAndView.addObject("painting", new Painting());
        paintingService.save(painting);
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
    @GetMapping("/edit-painting/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Painting painting) {
            ModelAndView modelAndView = new ModelAndView("/painting/edit");
            modelAndView.addObject("painting", painting);
            return modelAndView;
    }

    @PostMapping("/edit-painting")
    public ModelAndView updateCustomer(@ModelAttribute("painting") Painting painting) {
        paintingService.save(painting);
        ModelAndView modelAndView = new ModelAndView("/painting/edit");
        modelAndView.addObject("painting", painting);
        modelAndView.addObject("message", "Painting updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-painting")
    public ModelAndView showDeleteForm(@ModelAttribute("painting") Painting painting) {
        if (painting!=null) {
            ModelAndView modelAndView = new ModelAndView("/painting/delete");
            modelAndView.addObject("painting", painting);
            return modelAndView;

        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-painting")
    public String deletePainting(@ModelAttribute("painting") Painting painting) {
        paintingService.remove(painting.getId());
        return "redirect:paintings";
    }
    @GetMapping("/paintings")
    public ModelAndView list(@RequestParam("search") Optional<String> search,
                             @RequestParam("search2") Optional<Category> category,
                             Pageable pageable) {
        Page<Painting> paintings;
        if (search.isPresent() || category.isPresent()) {
            paintings = paintingRepository.findAllByNamePainting(search.get(), category.get(), (org.springframework.data.domain.Pageable) pageable);
        } else {
            paintings = paintingRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/painting/list");
        modelAndView.addObject("paintings", paintings);
        return modelAndView;
    }

}

