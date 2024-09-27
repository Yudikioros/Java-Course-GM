package mx.com.gm.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.IPersonaService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    private final IPersonaService personaService;

    public ControladorInicio(IPersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {

        var personas = personaService.listarPersonas();

        log.info("Ejecutando el controlador Spring MVC");
        log.info("Usuario: " + user.toString());
        model.addAttribute("personas", personas);

        return "index";
    }


    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {

        if(errores.hasErrors()) {
            return "modificar";
        }
        personaService.guardarPersona(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) {
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Persona persona, Model model) {
        personaService.eliminarPersona(persona);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Nombre de la plantilla de Thymeleaf (login.html)
    }

    @GetMapping("/errores/403")
    public String accessDenied() {
        return "errores/403"; // Nombre de la plantilla de Thymeleaf (403.html)
    }

}