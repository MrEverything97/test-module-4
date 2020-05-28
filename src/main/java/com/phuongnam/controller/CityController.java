package com.phuongnam.controller;

import com.phuongnam.model.City;
import com.phuongnam.model.Nation;
import com.phuongnam.service.CityService;
import com.phuongnam.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private NationService nationService;
    @ModelAttribute("nations")
    public Iterable<Nation> phones(){
        return nationService.findAll();
    }
    @GetMapping("/cities")
    public ModelAndView listCities(@PageableDefault(size = 3) Pageable pageable, @RequestParam("s") Optional<String> s ){
        Page<City> cities;
        if(s.isPresent()){
            cities = cityService.findAllByNameContainingIgnoreCase(s.get(), pageable);
        } else {
            cities = cityService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/create-city")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create-city")
    public ModelAndView saveCity(@ModelAttribute("city") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("city/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "Done!");
        return modelAndView;
    }

    @GetMapping("/edit-city/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        City city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("city/edit");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/edit-city")
    public ModelAndView updateCity(@ModelAttribute("city") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("city/edit");
        modelAndView.addObject("message", "Edit was successful !");
        return modelAndView;
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        City city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("city/delete");
        modelAndView.addObject("city", city);
        return modelAndView;

    }

    @PostMapping("/delete-city")
    public String deleteCity(@ModelAttribute("city") City city) {
        cityService.remove(city.getId());
        return "redirect:cities";
    }
    @GetMapping("/view-city/{id}")
    public ModelAndView showCityDetail(@PathVariable Long id) {
        City city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("city/view");
        modelAndView.addObject("city", city);
        return modelAndView;
    }
}
