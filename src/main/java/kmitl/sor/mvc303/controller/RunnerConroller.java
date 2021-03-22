package kmitl.sor.mvc303.controller;

import kmitl.sor.mvc303.model.dto.RunnerDTO;
import kmitl.sor.mvc303.model.entity.Runner;
import kmitl.sor.mvc303.model.service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RunnerConroller {
    @Autowired
    RunnerService service;
    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<RunnerDTO> listRunner = service.listAll();
        model.addAttribute("listRunner",listRunner);
        return "index";
    }
    @PostMapping("/register")
    public String saveNewRunner(@ModelAttribute("runner") @Valid Runner runner, BindingResult result,Model model){
        if (result.hasErrors()) {
            return "register";
        }
        service.saveRunner(runner);
        return "redirect:/";
    }
    @RequestMapping("/register/{id}")
    public ModelAndView showEditRunner(@PathVariable(name = "id")long id){
        ModelAndView mav = new ModelAndView("editLecturer");
        Runner runner = service.getRunner(id);
        mav.addObject("runner",runner);
        return mav;
    }
    @GetMapping("/register")
    public String showNewLecturer(Model model){
        Runner lecturer = new Runner();
        model.addAttribute("runner",lecturer);
        return "register";
    }
}
