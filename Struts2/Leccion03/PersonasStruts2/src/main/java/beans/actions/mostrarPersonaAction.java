package beans.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.*;

public class mostrarPersonaAction extends ActionSupport {
    
    Logger log = LogManager.getLogger(mostrarPersonaAction.class);
    
    private String nombre;
    
    public String execute(){
        log.info("El nombre de la persona es: " + nombre);
        return SUCCESS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
