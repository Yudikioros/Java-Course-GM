package mx.com.gm.actions;

import com.opensymphony.xwork2.ActionSupport;
import mx.com.gm.model.Persona;
import org.apache.logging.log4j.*;

public class PersonasAction extends ActionSupport {
    Logger log = LogManager.getLogger(PersonasAction.class);

    private Persona persona;

    @Override
    public String execute() throws Exception {
        if(this.persona != null) {
            log.info("\n");
            log.info("Persona: " + this.persona);
        }else {
            log.info("Persona nula");
        }
        return SUCCESS;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
