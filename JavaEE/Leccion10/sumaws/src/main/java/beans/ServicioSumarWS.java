package beans;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface ServicioSumarWS {
    @WebMethod
    public int sumar(int a, int b);
}
