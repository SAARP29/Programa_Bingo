import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bingo {
    //Solicitar Carton jugador
    //Pedir cantidad a apostar
    //Pedir cantidad de intentos para ganar premio maximo
    //Sacar numeros aleatorios hasta que se cante bingo
    //Mostrar datos de la partida
    public static void main(String[] args) {
        ArrayList<Integer> cartonJugador = generarCartonJugador(10);
        int apuestaJugador=pedirApuesta();
        int intentosPremioMaximo= pedirIntentos();
        empezarBingo(cartonJugador,apuestaJugador,intentosPremioMaximo);



    }
    public static ArrayList<Integer> generarCartonJugador(int size) {
        Random rd = new Random();
        boolean[]numerosUsados=new boolean[100];
        ArrayList<Integer> array1 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int aleatorio = rd.nextInt(99)+1;
            if (!numerosUsados[aleatorio]) {
                array1.add(aleatorio);
                numerosUsados[aleatorio]=true;
            }else {
                i--;
            }

        }
        return array1;
    }
    public static int pedirApuesta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la cantidad a apostar");
        return sc.nextInt();
    }
    public static int pedirIntentos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el numero de intentos para ganar el bingo");
        return sc.nextInt();
    }
    public static void empezarBingo(ArrayList<Integer>cartonJugador,int apuestaJugador,int intentosPremioMaximo) {
        ArrayList<Integer> numerosUsados = new ArrayList<>();
        int intentosParaLinea = 0;
        System.out.println("---Datos De La Partida---");
        System.out.println("Carton del Jugador " + cartonJugador);
        while (!cartonJugador.isEmpty()) {
            int numeroAleatorio = (int) (Math.random() * 99 + 1);
            if (numerosUsados.contains(numeroAleatorio)) {
                continue;
            }
            numerosUsados.add(numeroAleatorio);
            int posicionEnElCarton = cartonJugador.indexOf(numeroAleatorio);
            if (posicionEnElCarton == -1) {
                continue;
            }
            cartonJugador.remove(posicionEnElCarton);
            if (cartonJugador.size() == 5) {
                intentosParaLinea = numerosUsados.size();

            }
        }
        if (numerosUsados.size() == intentosPremioMaximo) {
            System.out.println("Ha ganado el Bote del Bingo " + apuestaJugador * 10);
        } else {
            System.out.println("No has conseguido el bote");
        }

        System.out.println("Numeros que salieron hasta el bingo: " + numerosUsados);
        System.out.println("Numeros para bingo  " + numerosUsados.size());
        System.out.println("Numeros para linea " + intentosParaLinea);

    }
}
