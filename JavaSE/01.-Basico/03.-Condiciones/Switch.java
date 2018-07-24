// Ejercicio 3.1 - Condicionales
public class Switch {
    public static void main(String[] args) {
        int binario = 0;

        switch (binario) {
            case 0:
                System.out.println("El numero en decimal es 0.");
                break;
            case 1:
                System.out.println("El numero en binario es 1");
            case 10:
                System.out.println("El numero en binario es 2.");
                break;
            case 11:
                System.out.println("El numero enbinarios es 3.");
            default:
                System.out.println("No se puede interpretar...");
                break;
        }
        String nivelEscolar = "Secundaria";


        // A partir de Java 7 se puede hacer con cadenas y/o caracteres
        switch (nivelEscolar) {
            case "Primaria":
                System.out.println("Escolaridad Primaria.");
                break;
            case "Secundaria":
                System.out.println("Escolaridad Secundaria.");
                break;
            case "Preparatoria":
                System.out.println("Escolaridad Preparatoria.");
                break;
            case "Universidad":
                System.out.println("Escolaridad Universitaria.");
            default:
                System.out.println("No la manejamos...");
                break;
        }
    }
}