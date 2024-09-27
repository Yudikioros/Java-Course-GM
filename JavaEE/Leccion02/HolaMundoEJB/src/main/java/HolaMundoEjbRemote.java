import jakarta.ejb.Remote;

@Remote
public interface HolaMundoEjbRemote {
    public int suma(int a, int b);
}
