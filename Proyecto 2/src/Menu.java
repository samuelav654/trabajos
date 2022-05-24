import java.util.Scanner;

public class Menu {
    public boolean inicializarJuego() {
        boolean tiporesultado = false;
        System.out.println("Bienvenido al juego de la invacion de los bichos");
        System.out.println("¿Quiere comenzar el Juego?");
        System.out.println("<--presione 1 para comenzar-->");
        Scanner scan = new Scanner(System.in);
        int numero = scan.nextInt();
        if (numero == 1) {

        }
        return tiporesultado;

    }

    public int opcionesJuego() {
        System.out.println("-----------MENU DE HABILIDADES-----------");
        System.out.println("--> Preciona 1 para disparar a un bicho");
        System.out.println("--> Preciona 2 para activar bomba atómica-(mata a un bicho aleatoriamente)");
        System.out.println("--> Preciona 3 para activar bicho mutante (puede que se vuelva mas dificil el juego)");
        System.out.println("--> Preciona 4 para intercambio de posiciones");
        System.out.println("--> Preciona 5 para conversión de sangre");
        System.out.println("--> Preciona 6 bomba de fila. Mata todos los bichos de una fila aleatoria");
        System.out.println(
                "--> Preciona 7 promedio tenebroso. Encuentra y muestra el promedio de salud que tienen los bichos vivos.");
        System.out.println("--> Preciona 8 La frase de la abuela");

        Scanner scan = new Scanner(System.in);
        int numero = scan.nextInt();
        return numero;
    }
}
