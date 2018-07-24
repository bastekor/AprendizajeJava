// Ejercicio 4 - Ciclos
public class Ciclos {
    public static void main(String[] args) {
        System.out.println("************************");
        for (int i = 0; i < 10; i++) {
            System.out.println("Vuelta " + (i + 1) + " en ciclo for.");
        }
        System.out.println("************************");

        int j = 0;
        while(j < 10) {
            System.out.println("Vuelta " + (j + 1) + " en ciclo while.");
            j++;
        }

        System.out.println("************************");
        int k = 0;
        do {
            System.out.println("Vuelta " + (k + 1) + " en ciclo do while.");
            k++;
        } while(k < 10);
        System.out.println("************************");
    }
}