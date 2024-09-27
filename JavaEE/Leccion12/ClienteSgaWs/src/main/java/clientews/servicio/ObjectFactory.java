
package clientews.servicio;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clientews.servicio package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetPersonas_QNAME = new QName("http://service.sga.gm.com.mx/", "getPersonas");
    private final static QName _GetPersonasResponse_QNAME = new QName("http://service.sga.gm.com.mx/", "getPersonasResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clientews.servicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPersonas }
     * 
     */
    public GetPersonas createGetPersonas() {
        return new GetPersonas();
    }

    /**
     * Create an instance of {@link GetPersonasResponse }
     * 
     */
    public GetPersonasResponse createGetPersonasResponse() {
        return new GetPersonasResponse();
    }

    /**
     * Create an instance of {@link Persona }
     * 
     */
    public Persona createPersona() {
        return new Persona();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonas }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPersonas }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.sga.gm.com.mx/", name = "getPersonas")
    public JAXBElement<GetPersonas> createGetPersonas(GetPersonas value) {
        return new JAXBElement<GetPersonas>(_GetPersonas_QNAME, GetPersonas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonasResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPersonasResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.sga.gm.com.mx/", name = "getPersonasResponse")
    public JAXBElement<GetPersonasResponse> createGetPersonasResponse(GetPersonasResponse value) {
        return new JAXBElement<GetPersonasResponse>(_GetPersonasResponse_QNAME, GetPersonasResponse.class, null, value);
    }

}
