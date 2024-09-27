package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.IPersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {

    private IPersonaDao personaDao;

    public ControladorInicio(IPersonaDao personaDao) {
        this.personaDao = personaDao;
    }

    @GetMapping("/")
    public String inicio(Model model) {

        var personas = personaDao.findAll();

        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);

        return "index";
    }

}
