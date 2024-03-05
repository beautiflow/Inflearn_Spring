package hello.typeconverter.controller;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormatterController {

    // 10,000 -> 10000
    // "2021-06-18 23:00:45" -> localDateTime
    @GetMapping("/formatter/edit")
    public String formatterForm(Model model){
        Form form = new Form();
        form.setNumber(10000);
        form.setLocalDateTime(LocalDateTime.now());
        model.addAttribute("form", form);
        return "formatter-form";
    }

    @PostMapping("formatter/edit")
    public String formatterEdit(@ModelAttribute Form form){
        return "formatter-view";
    }

    @Data
    static class Form{

        @NumberFormat(pattern = "###,###")
        private Integer number;

        @NumberFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime localDateTime;
    }

}
