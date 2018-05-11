package com.controllers;

import com.domain.Category;
import com.domain.UnitOfMeasure;
import com.repositories.CategoryRepository;
import com.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Cup");

        System.out.println("Category is: " + categoryOptional.get().getId());
        System.out.println("Category is: " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
