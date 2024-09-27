import jakarta.ejb.Stateless;

@Stateless
public class HolaMundoEjbImpl implements HolaMundoEjbRemote{

    @Override
    public int suma(int a, int b) {
        System.out.println("Ejecutando suma en el servidor");
        return a + b;
    }
}
