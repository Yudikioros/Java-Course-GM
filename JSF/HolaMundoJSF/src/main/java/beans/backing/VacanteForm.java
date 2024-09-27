package beans.backing;

import beans.model.Candidato;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class VacanteForm {
    @Inject
    private Candidato candidato;

    Logger log = LogManager.getRootLogger();

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public String enviar(){
        if(this.candidato.getNombre().equals("Juan")){
            log.info("Entrando al caso de exito");
            return "exito";
        }else {
            log.info("Entrando al caso de fallo");
            return "fallo";
        }
    }

}
