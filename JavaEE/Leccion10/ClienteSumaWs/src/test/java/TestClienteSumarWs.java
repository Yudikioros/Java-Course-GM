import clientews.servicio.ServicioSumarImplService;
import clientews.servicio.ServicioSumarWS;

public class TestClienteSumarWs {
    public static void main(String[] args) {
        ServicioSumarWS servicioSumar = new ServicioSumarImplService().getServicioSumarImplPort();
        System.out.println("ServicioSumarWS");
        int x = 3, y = 4;
        System.out.println("Resultado " + servicioSumar.sumar(x, y));
        System.out.println("Fin del servicioSumar");
    }
}
