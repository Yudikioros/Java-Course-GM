package utilerias;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversiones {
    private static final String FORMATO_FECHA = "dd-MM";

    public static String format(Date fecha){
        SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA);
        return formato.format(fecha);
    }
    public static String format(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA);
        return formato.format(fecha);
    }

}
