public class PrincipalJuego {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Tablero tablero = new Tablero();
        Menu opciones = new Menu();
        int opcionEscogida;
        Accion acciones = new Accion();
        Bicho[][] tableroGenerado;
        int indice = 1;

        menu.inicializarJuego();
        tableroGenerado = tablero.inicializar();
        tablero.mostrarTablero();
        while (indice == 1) {
            opcionEscogida = opciones.opcionesJuego();
            acciones.ejecutar(opcionEscogida, tableroGenerado);
            tablero.mostrarTablero();
            if (!tablero.validarTablero()) {
                indice = 2;
            }
        }

    }
}
