import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

public class OperacionesHibernateJPA {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();

        //Listar
        personaDAO.listar();

        Persona persona = new Persona();
        persona.setIdPersona(13);
        persona = personaDAO.buscarPersonaPorId(persona);

//        persona.setNombre("Carlos");
//        persona.setApellido("Esparza");
//        persona.setEmail("carlos@gmail.com");
//        persona.setTelefono("1234567890");

//        personaDAO.insertar(persona);

//        personaDAO.modificar(persona);

        personaDAO.eliminar(persona);


        personaDAO.listar();




    }
}
