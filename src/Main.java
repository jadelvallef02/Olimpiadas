import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int equipos = 5; // Número de equipos participantes
    static String[] nombresEquipos = {"Albacete", "Ciudad Real", "Cuenca", "Guadalajara", "Toledo"};
    static int[][] calendario = new int[10][2];
    static int[][] resultados = new int[10][2];
    static int[][] clasificacion = new int[equipos][7]; // Puntos, PJ, PG, PE, PP, GF, GC

    public static void main(String[] args) {
        generarCalendario();

        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        while (opcion != 6) {
            System.out.println("MENU:");
            System.out.println("1. Ver calendario");
            System.out.println("2. Introducir resultados");
            System.out.println("3. Mostrar tabla de resultados");
            System.out.println("4. Mostrar clasificación");
            System.out.println("5. Finalizar competición");
            System.out.println("6. Salir");
            System.out.println("Elija una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    verCalendario();
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    public static void generarCalendario() {
        int[][] tmpCalendario = new int[10][2];
        ArrayList<Integer> equiposLista = new ArrayList<Integer>();
        for (int i = 0; i < equipos; i++) {
            equiposLista.add(i);
        }
        int equipoDescanso = equipos - 1;
        int mitad = equipos / 2;
        int jornada = 0;
        boolean local = true;
        while (jornada < 10) {
            for (int i = 0; i < mitad; i++) {
                int equipoLocal = equiposLista.get(i);
                int equipoVisitante = equiposLista.get(equipos - i - 2);
                if (local) {
                    tmpCalendario[jornada][0] = equipoLocal;
                    tmpCalendario[jornada][1] = equipoVisitante;
                } else {
                    tmpCalendario[jornada][0] = equipoVisitante;
                    tmpCalendario[jornada][1] = equipoLocal;
                }
                jornada++;
            }
            equiposLista.add(1, equiposLista.remove(equipos - 2));
            local = !local;
            if (jornada == 5) {
                equiposLista.remove(equipoDescanso);
            }
        }
        calendario = tmpCalendario;
    }

    public static void verCalendario() {
        int numEquipos = 5;
        int jornadas = 10;
        int partidosPorJornada = numEquipos / 2;
        int local, visitante;

        int[][] calendario = new int[jornadas][partidosPorJornada * 2];

        for (int i = 0; i < jornadas; i++) {
            local = 0;
            for (int j = 0; j < partidosPorJornada; j++) {
                if (i % 2 == 0) {
                    visitante = local + 1;
                } else {
                    visitante = local;
                    local = (local + 1) % (numEquipos - 1);
                }
                calendario[i][j * 2] = local;
                calendario[i][j * 2 + 1] = visitante;
            }
        }

        System.out.println("Calendario de enfrentamientos:\n");
        for (int i = 0; i < jornadas; i++) {
            System.out.println("Jornada " + (i+1) + ":");
            for (int j = 0; j < partidosPorJornada; j++) {
                int equipoLocal = calendario[i][j * 2];
                int equipoVisitante = calendario[i][j * 2 + 1];
                System.out.println("Equipo " + (equipoLocal+1) + " - Equipo " + (equipoVisitante+1));
            }
            System.out.println();
        }
    }
}
