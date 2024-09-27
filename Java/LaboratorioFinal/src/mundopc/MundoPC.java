package mundopc;

import com.gm.mundopc.*;

public class MundoPC {

    public static void main(String[] args) {
        Monitor monitor = new Monitor("Samsung", 40);
        Raton raton = new Raton("USB", "Logitech");
        Teclado teclado = new Teclado("Bluetooth", "Corsair");

        Computadora pc = new Computadora("Boroneitor", monitor, teclado, raton);

        Orden orden = new Orden();
        orden.agregarComputadora(pc);
        orden.mostrarOrden();
    }

}
