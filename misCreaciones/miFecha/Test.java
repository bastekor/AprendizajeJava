import bastekor.fechas.fecha.Fecha;
import bastekor.fechas.fecha.FechaDetallada;
import bastekor.fechas.exceptions.FechaNoValidaException;
import bastekor.fechas.hora.Hora;
import bastekor.fechas.FechaHora;
public class Test {
    public static void main(String[] args) throws FechaNoValidaException {
        System.out.println("\n******************************************************************************************");
        System.out.println("Clase Fecha.java");
        System.out.println("\t* default puede ser utilizado para sacar la fecha del d\u00eda de hoy,\n\t  " +
                           "pero tambi\u00e9n puede utilizar sus setters y getters para asignar\n\t  " +
                           "el d\u00eda, mes y a\u00f1o que usted dese\u00e9.");
        System.out.println("------------------------------------------------------------------------------------------");
        Fecha f1 = new Fecha();
        Fecha f2 = new Fecha(30,07,2018);
        Fecha f3 = new Fecha("03/03/2017");
        Fecha f4 = new Fecha("01-01-1992");
        Fecha f5 = new Fecha("12_9_1990");
        Fecha f6 = new Fecha("28.12.2007");
        Fecha f7 = new Fecha().asignaCaracter("_");
        Fecha f8 = new Fecha(2, 2, 2000).asignaCaracter(".");
        Fecha f9 = new Fecha("01/10/1900").asignaCaracter("-");
        System.out.println("Ejemplos de utilizaci\u00f3n.");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("default - Fecha f1 = new Fecha();");
        System.out.println("int     - Fecha f2 = new Fecha(30, 07, 2018);");
        System.out.println("String  - Fecha f3 = new Fecha(\"03/03/2017\");");
        System.out.println("String  - Fecha f4 = new Fecha(\"01-01-1992\");");
        System.out.println("String  - Fecha f5 = new Fecha(\"12_9_1990\");");
        System.out.println("String  - Fecha f6 = new Fecha(\"28.12.2007\");");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + M\u00e9todo toString();");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(f1.toString());
        System.out.println(f2.toString());
        System.out.println(f3.toString());
        System.out.println(f4.toString());
        System.out.println(f5.toString());
        System.out.println(f6.toString());
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + M\u00e9todo asignarCaracter(String);");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("default - Fecha f7 = new Fecha().asignaCaracter(\"_\")");
        System.out.println("int     - Fecha f8 = new Fecha(2, 2, 2000).asignaCaracter(\".\");");
        System.out.println("String  - Fecha f9 = new Fecha(\"01/10/1900\").asignaCaracter(\"-\");");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + Metodo toString();");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(f7.toString());
        System.out.println(f8.toString());
        System.out.println(f9.toString());
        System.out.println("******************************************************************************************\n\n\n");
        
        System.out.println("\n******************************************************************************************");
        System.out.println("Clase FechaDetallada.java\n\t* Hereda de Clase Fecha.java.");
        System.out.println("------------------------------------------------------------------------------------------");
        FechaDetallada fd1 = new FechaDetallada();
        FechaDetallada fd2 = new FechaDetallada(30, 07, 2018);
        FechaDetallada fd3 = new FechaDetallada("13/12/2017");
        FechaDetallada fd4 = new FechaDetallada("11-11-1992");
        FechaDetallada fd5 = new FechaDetallada("12_2_1990");
        FechaDetallada fd6 = new FechaDetallada("28.11.2007");
        System.out.println("Ejemplos de utilizaci\u00f3n.");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("default - FechaDetallada fd1 = new FechaDetallada();");
        System.out.println("int     - FechaDetallada fd2 = new FechaDetallada(30, 07, 2018);");
        System.out.println("String  - FechaDetallada fd3 = new FechaDetallada(\"13/12/2017\");");
        System.out.println("String  - FechaDetallada fd4 = new FechaDetallada(\"11-11-1992\");");
        System.out.println("String  - FechaDetallada fd5 = new FechaDetallada(\"12_2_1990\");");
        System.out.println("String  - FechaDetallada fd6 = new FechaDetallada(\"28.11.2007\");");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + M\u00e9todo toString();");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(fd1.toString());
        System.out.println(fd2.toString());
        System.out.println(fd3.toString());
        System.out.println(fd4.toString());
        System.out.println(fd5.toString());
        System.out.println(fd6.toString());
        System.out.println("******************************************************************************************\n\n\n");

        System.out.println("\n******************************************************************************************");
        System.out.println("Clase Hora.java");
        System.out.println("------------------------------------------------------------------------------------------");
        Hora h1 = new Hora();
        Hora h2 = new Hora(10, 23, 40);
        Hora h3 = new Hora("12:34:20");
        System.out.println("Ejemplos de utilizaci\u00f3n."); 
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("default - Hora h1 = new Hora();");
        System.out.println("int     - Hora h2 = new Hora(10, 23, 40);");
        System.out.println("String  - Hora h3 = new Hora(\"12:34:20\");");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + M\u00e9todo toString();");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        System.out.println(h3.toString());
        System.out.println("******************************************************************************************\n\n\n");

        System.out.println("\n******************************************************************************************");
        System.out.println("Clase FechaHora.java\n\t" + 
                           "* Se utiliza como si fuera una interface o vista.");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Ejemplos de utilizaci\u00f3n.");
        String m1 = FechaHora.tomarFecha();
        String m2 = FechaHora.tomarFechaDetallada();
        String m3 = FechaHora.tomarHora();
        String m4 = FechaHora.tomarFechaConHora();
        String m5 = FechaHora.tomarFechaDetalladaConHora();

        String m6 = FechaHora.crearFecha(10, 10, 1910);
        String m7 = FechaHora.crearFecha("31.12.2000");

        String m8 = FechaHora.crearFechaDetallada(23, 10, 2018);
        String m9 = FechaHora.crearFechaDetallada("01/01/2000");

        String m10 = FechaHora.crearHora(24, 0, 0);
        String m11 = FechaHora.crearHora("23:50:59");

        String m12 = FechaHora.crearFechaConHora("01/01/2010", "10:09:10");
        String m13 = FechaHora.crearFechaDetalladaConHora(m1, m3);
        
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + M\u00e9todo Est\u00e1tico\n\tString m1 = FechaHora.tomarFecha();");
        System.out.println("\t" + m1 + "\n");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + M\u00e9todo Est\u00e1tico\n\tString m2 = FechaHora.tomarFechaDetallada();");
        System.out.println("\t" + m2 + "\n");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + M\u00e9todo Est\u00e1tico\n\tString m3 = FechaHora.tomarHora();");
        System.out.println("\t" + m3 + "\n");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + M\u00e9todo Est\u00e1tico\n\tString m4 = FechaHora.tomarFechaConHora();");
        System.out.println("\t" + m4 + "\n");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + M\u00e9todo Est\u00e1tico\n\tString m5 = FechaHora.tomarFechaDetalladaConHora();");
        System.out.println("\t" + m5 + "\n");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + M\u00e9todo Est\u00e1tico\n\tString m6 = FechaHora.crearFecha(10, 10, 1910);");
        System.out.println("\t" + m6 + "\n");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + M\u00e9todo Est\u00e1tico\n\tString m7 = FechaHora.crearFecha(\"31.12.2000\");");
        System.out.println("\t" + m7 + "\n");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + M\u00e9todo Est\u00e1tico\n\tString m8 = FechaHora.crearFechaDetallada(23, 10, 2018);");
        System.out.println("\t" + m8 + "\n");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + M\u00e9todo Est\u00e1tico\n\tString m9 = FechaHora.crearFechaDetallada(\"01/01/2000\");");
        System.out.println("\t" + m9 + "\n");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + M\u00e9todo Est\u00e1tico\n\tString m10 = FechaHora.crearHora(24, 0, 0);");
        System.out.println("\t" + m10 + "\n");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + M\u00e9todo Est\u00e1tico\n\tString m11 = FechaHora.crearHora(\"23:50:59\");");
        System.out.println("\t" + m11 + "\n");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + M\u00e9todo Est\u00e1tico\n\tString m12 = FechaHora.crearFechaConHora(\"01/01/2010\", \"10:09:10\");");
        System.out.println("\t" + m12 + "\n");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" + M\u00e9todo Est\u00e1tico\n\tString m13 = FechaHora.crearFechaDetalladaConHora(m1, m3);");
        System.out.println("\t" + m13 + "\n");
        System.out.println("******************************************************************************************");
    
    }

}