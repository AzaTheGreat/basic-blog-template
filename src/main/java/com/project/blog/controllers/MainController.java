package com.project.blog.controllers;

import com.project.blog.models.About;
import com.project.blog.repo.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Main Page");
        return "home";
    }

    @Autowired
    private AboutRepository aboutRepository;

    @GetMapping("/about")
    public String about(Model model) {
        Iterable<About> data = aboutRepository.findAll();
        model.addAttribute("info", data);
        model.addAttribute("title", "About Us");
        return "about";
    }

    @PostMapping("/about")
    public String blogPostAdd(@RequestParam String info, Model model) {
        About post = new About(info);
        aboutRepository.save(post);
        return "redirect:/about";
    }

    @GetMapping("/about/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        if(!aboutRepository.existsById(id)) {
            return "redirect:/about";
        }

        Optional<About> post = aboutRepository.findById(id);
        ArrayList<About> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("info", res);
        return "about-details";
    }
}