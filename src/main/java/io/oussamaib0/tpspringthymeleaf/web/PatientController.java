package io.oussamaib0.tpspringthymeleaf.web;

import io.oussamaib0.tpspringthymeleaf.entities.Patient;
import io.oussamaib0.tpspringthymeleaf.services.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class PatientController {
    private final IPatientService patientService;

    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "5") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Patient> pagePatients = patientService.findByNameContainsIgnoreCase(keyword, PageRequest.of(page, size));
        model.addAttribute("listPatients", pagePatients.getContent());
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pagePatients.getTotalPages());
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    @GetMapping("/patient-delete/{id}")
    public String delete(
            @PathVariable Long id,
            @RequestParam(name = "keyword", defaultValue = "") String keyword,
            @RequestParam(name = "page", defaultValue = "0") int page
    ) {
        patientService.deletePatient(id);
        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }
}
