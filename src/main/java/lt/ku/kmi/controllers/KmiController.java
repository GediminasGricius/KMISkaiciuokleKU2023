package lt.ku.kmi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KmiController {

    @GetMapping("/")
    public String home(Model model){
        return "skaiciuokle";
    }

    @PostMapping("/")
    public String apskaiciuoti(
            @RequestParam("svoris") Integer svoris,
            @RequestParam("ugis") Integer ugis,
            Model model
    ){
        double kmi= Math.round((svoris  / Math.pow(ugis/100.0, 2))*100)/100.0;
        model.addAttribute("kmi",kmi);
        if (kmi<=25){
            model.addAttribute("kmiClass", "alert-success");
        }
        if (kmi>25 && kmi<=30){
            model.addAttribute("kmiClass", "alert-warning");
        }
        if (kmi>30){
            model.addAttribute("kmiClass", "alert-danger");
        }

        return "skaiciuokle";
    }


}
