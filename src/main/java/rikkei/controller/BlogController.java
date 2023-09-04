package rikkei.controller;

import com.ibm.j9ddr.vm29.pointer.generated._jfieldIDPointer;
import jdk.internal.icu.text.NormalizerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import rikkei.model.entity.Blog;
import rikkei.model.repository.IBlogRepository;
import rikkei.model.service.IBlogService;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping
    private String list(Model model){
        model.addAttribute("blog",blogService.findAll());
        return "list";
    }
    @GetMapping("/add")
    private ModelAndView add(Model model){
       return new ModelAndView("add","blog",new Blog());
    }
    @GetMapping("/edit/{id}")
    private ModelAndView edit(@PathVariable Long id){
        return new ModelAndView("edit","blog",blogService.findById(id));
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable Long id){
        blogService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }





}
