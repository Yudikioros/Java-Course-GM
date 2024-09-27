import domain.Persona;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class PruebaRestWs {
    public static void main(String[] args) {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
                .nonPreemptive()
                .credentials("admin","admin")
                .build();
        ClientConfig config = new ClientConfig();
        config.register(feature);

        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target("http://localhost:8080/sga-jee-web/webservice").path("/personas");
        //Proporcionamos un idPersona valido
        Persona persona = target.path("/2")
                .request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona recuperada: " + persona);
    }
}
