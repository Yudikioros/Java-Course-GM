package beans;

import jakarta.ejb.Stateless;
import jakarta.jws.WebService;

@Stateless
@WebService(endpointInterface = "beans.ServicioSumarWS")
public class ServicioSumarImpl implements ServicioSumarWS {

    @Override
    public int sumar(int a, int b) {
        return a+b;
    }
}
