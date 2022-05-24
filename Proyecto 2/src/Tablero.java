import java.util.Random;

public class Tablero {

    int cantidadBichos;
    Bicho[] bichosGenerados;
    Bicho[][] table = new Bicho[3][3];

    public void mostrarTablero() {

        System.out.println("---------------------------------------------------------------");
        for (int row1 = 0; row1 < table.length; row1++) {
            for (int col1 = 0; col1 < table[row1].length; col1++)
                if (table[row1][col1] != null)

                    System.out.print("|" + table[row1][col1] + "|");
                else
                    System.out.print("|                   |");
            System.out.println();

        }
        System.out.println("---------------------------------------------------------------");
    }

    public Bicho[][] inicializar() {
        GenerarCantidadBichos();
        GenerarTipoBichos();
        asignarBichos();

        return table;
    }

    void GenerarCantidadBichos() {
        Random cantidad = new Random();
        cantidadBichos = cantidad.nextInt(9);
    }

    void GenerarTipoBichos() {
        Random cantidadtipos = new Random();
        bichosGenerados = new Bicho[cantidadBichos];
        int tipoBichos;

        for (int i = 0; i < cantidadBichos; i++) {
            tipoBichos = cantidadtipos.nextInt(4);
            switch (tipoBichos) {
                case 2:
                    bichosGenerados[i] = new BichoAlien();

                    break;
                case 3:
                    bichosGenerados[i] = new BichoEspacial();

                    break;

                default:
                    bichosGenerados[i] = new Bicho();
                    break;
            }

        }

    }

    void asignarBichos() {
        int indiceBichos = 0;
        for (int columnas = 0; columnas < 3; columnas++)
            for (int filas = 0; filas < 3; filas++) {
                if (indiceBichos < bichosGenerados.length) {
                    table[columnas][filas] = bichosGenerados[indiceBichos];
                }
                indiceBichos++;

            }
    }

    public boolean validarTablero() {

        for (int columnas = 0; columnas < 3; columnas++)
            for (int filas = 0; filas < 3; filas++) {
                if (table[columnas][filas] != null && table[columnas][filas].getVida() > 0)
                    return true;
            }
        return false;

    }

}