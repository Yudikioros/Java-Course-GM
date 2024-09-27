package domain;

public class UsuarioDTO {
    private int id_usuario;
    private String usuario;
    private String password;

    public UsuarioDTO() {

    }

    public UsuarioDTO(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public UsuarioDTO(int id_usuario, String usuario, String password) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.password = password;
    }

    public UsuarioDTO(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UsuarioDTO{");
        sb.append("id_usuario=").append(id_usuario);
        sb.append(", usuario='").append(usuario).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
