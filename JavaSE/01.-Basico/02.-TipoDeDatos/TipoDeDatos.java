// Ejercicio 02 - Tipo de Datos
public class TipoDeDatos {
    public static void main(String args[]) {
        /*
        TIPO DE DATOS PRIMITIVOS
        */

        byte   bNumero = 1;
        int    iNumero = 10;
        double dNumero = 12.5;
        float  fNumero = 12.123456f; // Una "f o F" al final indica que es float
        long   lNumero = 1234567890l; // Una "l o L" al final indica que es un long
        short  sNumero = 12;

        // Verdadero o falso
        boolean bTrue  = true;
        boolean bFalse = false;

        // Caracteres
        char cCaracter = 'A';
        
        System.out.println("\nTIPOS DE DATOS PRIMITIVOS.");
        System.out.println("**************************");
        System.out.println("int     :: " + iNumero);
        System.out.println("double  :: " + dNumero);
        System.out.println("float   :: " + fNumero);
        System.out.println("long    :: " + lNumero);
        System.out.println("short   :: " + sNumero);
        System.out.println("boolean :: " + bTrue);
        System.out.println("boolean :: " + bFalse);
        System.out.println("char    :: " + cCaracter);
        System.out.println("**************************");

        /*
        TIPOS ENVOLTORIO O WRAPPER
        */

        Byte      Bbyte      = new Byte(bNumero);
        Integer   Iint       = new Integer(iNumero);
        Double    Ddouble    = new Double(dNumero);
        Float     Ffloat     = new Float(fNumero);
        Long      Llong      = new Long(lNumero);
        Short     Sshort     = new Short(sNumero);
        Boolean   Bboolean_1 = new Boolean(bTrue);
        Boolean   Bboolean_2 = new Boolean(bFalse);
        Character Cchar      = new Character(cCaracter);

        System.out.println("\nTIPOS DE WRAPPER");
        System.out.println("**************************");
        System.out.println("Byte      :: " + Bbyte);
        System.out.println("Integer   :: " + Iint);
        System.out.println("Double    :: " + Ddouble);
        System.out.println("Float     :: " + Ffloat);
        System.out.println("Long      :: " + Llong);
        System.out.println("Short     :: " + Sshort);
        System.out.println("Boolean   :: " + Bboolean_1);
        System.out.println("Boolean   :: " + Bboolean_2);
        System.out.println("Character :: " + Cchar);
        System.out.println("**************************");

        /*
        TIPOS DE BIBLIOTECAS ESTANDAR
        */
        String sCadena = "Soy una Cadena...";
        System.out.println("String :: " + sCadena);
    }
}