import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.Random;

public class Accion {
    public void ejecutar(int opcion, Bicho[][] tablerBichos) {
        switch (opcion) {
            case 1:
                disparar(tablerBichos);

                break;

            case 2:
                bombaAtomica(tablerBichos);

                break;

            case 3:
                bichoMutante(tablerBichos);

                break;

            case 4:
                intercambiarposiciones(tablerBichos);

                break;

            case 5:
                comvertirSangre(tablerBichos);

                break;

            case 6:
                bombardearFila(tablerBichos);

                break;

            case 7:
                generarPromedioTenebroso(tablerBichos);

                break;

            case 8:
                generarFrasedelaabuela(tablerBichos);

                break;

        }

    }

    private void disparar(Bicho[][] tablerBichos) {
        System.out.println("Escoje la fila a la que quiere disparar (numero del 0 al 2)");
        Scanner scan = new Scanner(System.in);
        int numerodefila = scan.nextInt();
        System.out.println("Escoje la columna a la que quiere disparar (numero del 0 al 2)");
        int numerodecolumna = scan.nextInt();
        if (numerodefila < 0 || numerodefila > 2 || numerodecolumna < 0 || numerodecolumna > 2) {
            System.out.println("Opcion de lugar de disparo invalido");
            return;
        }
        if (tablerBichos[numerodefila][numerodecolumna] != null)
            tablerBichos[numerodefila][numerodecolumna].reducirVida(5);

    }

    private void bombaAtomica(Bicho[][] tablerBichos) {
        Random cantidad = new Random();

        int numerodefila = cantidad.nextInt(3);
        int numerodecolumna = cantidad.nextInt(3);
        if (tablerBichos[numerodefila][numerodecolumna] != null)

        {
            tablerBichos[numerodefila][numerodecolumna].reducirVida(30);

            System.out.println("la Bomba cayo sobre el bicho " + tablerBichos[numerodefila][numerodecolumna] +
                    " en la fila " + numerodefila
                    + " en la columna " + numerodecolumna);
        }

        else
            System.out.println("La bomba no le dio a ningun bicho");
    }

    private void bichoMutante(Bicho[][] tablerBichos) {
        Bicho bichoMenorVida = tablerBichos[0][0];
        for (int fila = 0; fila < 3; fila++)
            for (int columna = 0; columna < 3; columna++) {
                if (tablerBichos[fila][columna] != null && bichoMenorVida != null
                        && tablerBichos[fila][columna].getVida() > 0 &&
                        bichoMenorVida.getVida() > tablerBichos[fila][columna].getVida()) {

                    bichoMenorVida = tablerBichos[fila][columna];
                }
            }
        bichoMenorVida.setVida(bichoMenorVida.getVida() * 2);
        System.out.println("El bicho con menor vida mutó... " + bichoMenorVida + " Vida: " + bichoMenorVida.getVida());
    }

    private void intercambiarposiciones(Bicho[][] tablerBichos) {
        Random intercambio = new Random();

        int numerodefilaoriginal = intercambio.nextInt(3);
        int numerodecolumnaoriginal = intercambio.nextInt(3);
        int numerodefilacambiada = intercambio.nextInt(3);
        int numerodecolumnacambiada = intercambio.nextInt(3);
        Bicho bichoAcambiar = tablerBichos[numerodefilaoriginal][numerodecolumnaoriginal];
        tablerBichos[numerodefilaoriginal][numerodecolumnaoriginal] = tablerBichos[numerodefilacambiada][numerodecolumnacambiada];
        tablerBichos[numerodefilacambiada][numerodecolumnacambiada] = bichoAcambiar;
        System.out.println("se intercambiaron " + numerodefilaoriginal + " " + numerodecolumnaoriginal + " por "
                + numerodefilacambiada + " " + numerodecolumnacambiada);

    }

    private void comvertirSangre(Bicho[][] tablerBichos) {
        Bicho bichoMenorVida = tablerBichos[0][0];
        int filabichomenorvida = 0;
        int columnabichomenorvida = 0;

        for (int fila = 0; fila < 3; fila++)
            for (int columna = 0; columna < 3; columna++) {
                if (tablerBichos[fila][columna] != null && bichoMenorVida != null
                        && tablerBichos[fila][columna].getVida() > 0 &&
                        bichoMenorVida.getVida() > tablerBichos[fila][columna].getVida()) {

                    bichoMenorVida = tablerBichos[fila][columna];
                    filabichomenorvida = fila;
                    columnabichomenorvida = columna;
                }
            }
        tablerBichos[filabichomenorvida][columnabichomenorvida] = new BichoEspacial();
        tablerBichos[filabichomenorvida][columnabichomenorvida].setVida(bichoMenorVida.getVida());
    }

    private void bombardearFila(Bicho[][] tablerBichos) {

        Random intercambio = new Random();

        int numerodefilaleatoria = intercambio.nextInt(3);
        for (int columna = 0; columna < 3; columna++) {
            if (tablerBichos[numerodefilaleatoria][columna] != null)
                tablerBichos[numerodefilaleatoria][columna].reducirVida(30);

        }
    }

    private void generarPromedioTenebroso(Bicho[][] tablerBichos) {
        int sumatoriasalud = 0;
        int cantidad = 0;
        float promedio = 0;

        for (int fila = 0; fila < 3; fila++)
            for (int columna = 0; columna < 3; columna++) {
                if (tablerBichos[fila][columna] != null) {
                    cantidad++;
                    sumatoriasalud += tablerBichos[fila][columna].getVida();

                }
            }
        if (cantidad > 0)
            promedio = sumatoriasalud / cantidad;

        System.out.println("El promedio de salud de los bichos es de " + promedio);

    }

    private void generarFrasedelaabuela(Bicho[][] tablerBichos) {
        String[] x = { "la abuela cuando jugaba a matar bichos, su mamá estaba en pañales",
                "terminalos de matar antes que esté el chocolate",
                "mijo, póngase saco antes que ese bicho lo muerda" };
        Random rand = new Random();

        int n = rand.nextInt(4);
        String p = x[n];

        System.out.println(p);
    }

}
