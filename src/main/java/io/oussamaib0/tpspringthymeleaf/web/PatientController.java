package io.oussamaib0.tpspringthymeleaf.web;

import io.oussamaib0.tpspringthymeleaf.services.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class PatientController {
    private final IPatientService patientService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "index";
    }
}
