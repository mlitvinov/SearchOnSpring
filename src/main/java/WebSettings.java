package com.example.handlingformsubmission;

import com.example.handlingformsubmission.Data.Data;
import com.example.handlingformsubmission.Data.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebSettings {

    @GetMapping("/find")
    public String webForm(Model model) {
        model.addAttribute("person", new Person());
        return "greeting";
    }

    @PostMapping("/find")
    public String webSubmit(@ModelAttribute Person person, Model model) {
        model.addAttribute("person", person);
        Data.findPersonData(person);
        return "result";
    }
}
