package mx.com.gm.model;

public class Domicilio {
    private String calle;
    private int numeroCalle;
    private String pais;

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(int numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Domicilio{");
        sb.append("calle='").append(calle).append('\'');
        sb.append(", numeroCalle=").append(numeroCalle);
        sb.append(", pais='").append(pais).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
