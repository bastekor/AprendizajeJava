// Ejercicio 03 - Condicionales

public class IfElse {
    public static void main(String[] args) {
        int edad = 18;
        
        if (edad >= 18) {
            System.out.println("Ya eres mayor de edad.");
        } else {
            System.out.println("No eres mayor de edad.");
        }

        String vivoraDeLaMar = "Melon";

        if ("Melon".equals(vivoraDeLaMar)) {
            System.out.println("Sera Melon");
        } else if ("Sandia".equals(vivoraDeLaMar)) {
            System.out.println("Sera Sandia");
        } else {
            System.out.println("Sera la vieja del otro dia...");
        }
    }
}