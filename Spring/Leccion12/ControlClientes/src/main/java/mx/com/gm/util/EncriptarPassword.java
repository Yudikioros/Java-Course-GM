package mx.com.gm.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
    public static void main(String[] args) {

        var password = "123";
        System.out.println("PASSWORD: " + password);
        System.out.println("PASSWORD ENCRIPTADO: " + encriptarPassword(password));

    }
    public static String encriptarPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
