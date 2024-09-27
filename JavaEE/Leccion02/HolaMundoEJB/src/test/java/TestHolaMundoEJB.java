import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestHolaMundoEJB {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        try {
            Context jndi = new InitialContext();
            HolaMundoEjbRemote holaMundoEjb = (HolaMundoEjbRemote) jndi.lookup(
                    "java:global/HolaMundoEJB/HolaMundoEjbImpl!HolaMundoEjbRemote");
            int resultado  = holaMundoEjb.suma(5, 3);
            System.out.println("Resultado: " + resultado);
        }catch (NamingException exception){
            exception.printStackTrace(System.out);
        }
    }
}
