package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.servicio.IPersonaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {

    private final IPersonaService personaService;

    public ControladorInicio(IPersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/")
    public String inicio(Model model) {

        var personas = personaService.listarPersonas();

        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);

        return "index";
    }

}
