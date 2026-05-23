package tresenraya;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TresEnRaya {

    private static String nombreJuego = "BIENVENIDO AL TRES EN RAYA!";

    //creamos los jugadores
    private static String jugador1 = "X";
    private static String jugador2 = "O";

    //crear tablero 
    private static String[][] tablero = {
        {"1", "2", "3"},
        {"4", "5", "6"},
        {"7", "8", "9"}
    };

    //Crear un hashmap 
    private static Map<Integer, int[]> coordenadas = new HashMap<>();

    //MÉTODO PARA TRADUCIR
    private static void traducirCoordenadas() {
        //Fila 0
        coordenadas.put(1, new int[]{0, 0});
        coordenadas.put(2, new int[]{0, 1});
        coordenadas.put(3, new int[]{0, 2});

        //Fila 1
        coordenadas.put(4, new int[]{1, 0});
        coordenadas.put(5, new int[]{1, 1});
        coordenadas.put(6, new int[]{1, 2});

        //Fila 2
        coordenadas.put(7, new int[]{2, 0});
        coordenadas.put(8, new int[]{2, 1});
        coordenadas.put(9, new int[]{2, 2});
    }

    //Crear un método que me diga si el numero que he elegido ya ha sido usado
    private static boolean siUsado(int numElegido, int[] usados) {
        for (int i = 0; i < usados.length; i++) {
            if (numElegido == usados[i]) {
                return true;
            }
        }
        return false;
    }

    //Victorias
    private static boolean ganador(String jugador) {

        for (int i = 0; i < 3; i++) {
            //filas
            if (tablero[i][0].equals(jugador) && tablero[i][1].equals(jugador) && tablero[i][2].equals(jugador)) {
                return true;
            }

            //columnas
            if (tablero[0][i].equals(jugador) && tablero[1][i].equals(jugador) && tablero[2][i].equals(jugador)) {
                return true;
            }

            //diagonal izq-der
            if (tablero[0][0].equals(jugador) && tablero[1][1].equals(jugador) && tablero[2][2].equals(jugador)) {
                return true;
            }

            //diagonal der-izq
            if (tablero[2][0].equals(jugador) && tablero[1][1].equals(jugador) && tablero[0][2].equals(jugador)) {
                return true;
            }
        }

        return false;
    }

    //crear método para printear el tablero 
    private static void printTablero() {

        for (int i = 0; i < 3; i++) {

            System.out.println("---+---+---");

            for (int j = 0; j < 3; j++) {
                System.out.print(" " + tablero[i][j] + " |");
            }
            System.out.println();
        }

        System.out.println("---+---+---");
    }

    public static void main(String[] args) {
        //Declarar variables 
        int numElegido = 0;
        int contador = 0;
        String jugarOtraVez = "";
        int vX = 0;
        int vO = 0;
        int empate = 0;

        int usados[] = new int[9];
        int[] traducirNumACoordenada;
        Boolean juego = true;
        Boolean turnoX = true;

        Scanner sc = new Scanner(System.in);

        //Llamar al método traducir coordenadas para que haga la conversión 
        traducirCoordenadas();

        //Inicio del juego 
        System.out.println(TresEnRaya.nombreJuego);

        do {
            juego = true;
            turnoX = true;
            contador = 0;
            usados = new int[9];
            tablero = new String[][]{
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
            };

            System.out.println();

            System.out.println("""
                           CONTADOR
                           *********************""");
            System.out.println("VICTORIAS X - " + vX);
            System.out.println("VICTORIAS O - " + vO);
            System.out.println("EMPATES - " + empate);

            System.out.println("""
                           *********************
                           """);

            printTablero();

            while (juego) {
                if (turnoX && juego) {

                    //pedir numero a X
                    while (numElegido < 1 || numElegido > 9 || siUsado(numElegido, usados)) {
                        System.out.println("Dime que posición quieres");
                        numElegido = sc.nextInt();
                    }

                    //añadir nums usados al array
                    usados[contador] = numElegido;
                    contador++;

                    //sustitución
                    traducirNumACoordenada = coordenadas.get(numElegido);
                    tablero[traducirNumACoordenada[0]][traducirNumACoordenada[1]] = TresEnRaya.jugador1;

                    //comprobar si es ganador o es empate
                    if (ganador(jugador1)) {
                        System.out.println("""
                                       
                                       GANA X!
                                       
                                       RESULTADO:""");
                        juego = false;
                        vX++;
                    } else if (contador == 9) {
                        System.out.println("""
                                       
                                       Fin del Juego. Ha sido empate
                                       
                                       RESULTADO:""");
                        juego = false;
                        empate++;
                    }

                    //printear tablero y cambiar de jugador
                    printTablero();
                    turnoX = false;
                    numElegido = 0;
                }
                if (!turnoX && juego) {

                    //pedir numero a y 
                    while (numElegido < 1 || numElegido > 9 || siUsado(numElegido, usados)) {
                        System.out.println("Dime que posición quieres");
                        numElegido = sc.nextInt();
                    }

                    //añadir nums usados al array
                    usados[contador] = numElegido;
                    contador++;

                    //sustitución
                    traducirNumACoordenada = coordenadas.get(numElegido);
                    tablero[traducirNumACoordenada[0]][traducirNumACoordenada[1]] = TresEnRaya.jugador2;

                    //comprobar si es ganador
                    if (ganador(jugador2)) {
                        System.out.println("""
                                       
                                       GANA O!
                                       
                                       RESULTADO:""");
                        juego = false;
                        vO++;

                    }

                    printTablero();
                    turnoX = true;
                    numElegido = 0;
                }

            }
            //Validar si se escribe si o no para jugar otra vez
            sc.nextLine();
            System.out.println("¿Quieres volver a jugar? Si / No");
            jugarOtraVez = sc.nextLine().toLowerCase();

            while (!jugarOtraVez.equals("si") && !jugarOtraVez.equals("no")) {
                System.out.println("Escribe solo 'si' o 'no'");
                jugarOtraVez = sc.nextLine().toLowerCase();
            }

        } while (jugarOtraVez.equals("si"));

        //Mostrar resultados aunque haya acabado el juego 
        System.out.println();

        System.out.println("""
                           CONTADOR
                           *********************""");
        System.out.println("VICTORIAS X - " + vX);
        System.out.println("VICTORIAS O - " + vO);
        System.out.println("EMPATES - " + empate);

        System.out.println("""
                           *********************
                           """);
    }
}