import java.util.ArrayList;
import java.util.Scanner;

public class Main {
public static Scanner sc = new Scanner(System.in);
    public int mostrarMenu(){
        System.out.println("MENU:");
        System.out.println("1. Ver calendario");
        System.out.println("2. Introducir resultados");
        System.out.println("3. Mostrar tabla de resultados");
        System.out.println("4. Mostrar clasificación");
        System.out.println("5. Finalizar competición");
        System.out.println("6. Salir");
        System.out.println("Elija una opción: ");
        return sc.nextInt();
    }
    public static void main(String[] args) {

    }
}
