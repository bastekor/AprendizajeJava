package bastekor.fechas.fecha;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import bastekor.fechas.exceptions.FechaNoValidaException;

/**
 * <h3><strong>Clase Fecha</strong></h3><br>
 * <h4><strong><u>Objetivo:</u></strong></h4><br>
 * Permite generar fechas de una manera facil y entendible de la siguiente
 * manera:<br>
 * <ul>
 * <li>Instancia de Fecha - <strong>new Fecha();</strong></li>
 * <li>Esperando dia, mes y año (numerico) - <strong>new Fecha(12,6,2018);</strong></li>
 * <li>Esperando fecha con formato
 * <ul>
 * <li>dd/mm/aaaa - <strong>new Fecha("05/12/2018");</strong></li>
 * <li>dd-mm-aaaa - <strong>new Fecha("05-12-2018");</strong></li>
 * <li>dd_mm_aaaa - <strong>new Fecha("05_12_2018");</strong></li>
 * <li>dd_mm_aaaa - <strong>new Fecha("05.12.2018");</strong></li>
 * </ul>
 * </li>
 * <li>Fecha actual - <strong>Desde que se crea la instancia ya esta
 * inicializada la fecha actual</strong></li>
 * </ul>
 * 
 * @author LEDZ
 * @version 1.0
 */
public class Fecha extends FechaNoValidaException {

    private static final long serialVersionUID = 1L;

    protected static String[] NOMBRE_DEL_MES = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", 
        "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };
    private static int[] DIAS_DEL_MES = {
        31, // enero
        28, // febrero
        31, // marzo
        30, // abril
        31, // mayo
        30, // junio
        31, // julio
        31, // agosto
        30, // septiembre
        31, // octubre
        30, // noviembre
        31 // diciembre
    };
    private static String[] ANIO_BISIESTO_SIGLO_XXI = {
        "2004", "2008", "2012", "2016", "2020", "2024", "2028", "2032", 
        "2036", "2040", "2044", "2048", "2052", "2056", "2060", "2064", 
        "2068", "2072", "2076", "2080", "2084", "2088", "2092", "2096"
    };

    /**
     * Caracter del formato de la fecha. Inicialmente es una / pero puede ser
     * cambiada a alguna de las 4 opciones mostradas:
     * <ul>
     * <li>Diagonal. <strong>/</strong></li>
     * <li>Guion medio. <strong>-</strong></li>
     * <li>Guion bajo. <strong>-</strong></li>
     * <li>Punto. <strong>.</strong></li>
     * </ul>
     */
    private String formatoCaracter = "/";

    /**
     * Dia de la fecha
     */
    private int iDia;

    /**
     * Mes de la fecha
     */
    private int iMes;

    /**
     * Año de la fecha
     */
    private int iAnio;

    // Constructores

    /**
     * Constructor por default, se inicializa con la fecha actual.<br>
     * Formato por defecto <strong>dd/mm/aaaa.</strong>
     */
    public Fecha() {
        LocalDate hoy = LocalDate.now();
        this.iDia = hoy.getDayOfMonth();
        this.iMes = hoy.getMonthValue();
        this.iAnio = hoy.getYear();
    }

    /**
     * Constructor con parametros dia, mes y año.<br>
     * Formato por defecto <strong>dd/mm/aaaa.</strong>
     * 
     * @param iDia  <strong>Dia de la fecha.</strong>
     * @param iMes  <strong>Mes de la fecha.</strong>
     * @param iAnio <strong>Año de la fecha.</strong>
     * @throws FechaNoValidaException Error - el formato y/o la fecha no son
     *                                validas.
     */
    public Fecha(int iDia, int iMes, int iAnio) throws FechaNoValidaException {
        this(
            (String.valueOf(iDia).length() < 2 ? "0" + iDia : iDia) + "/" +
            (String.valueOf(iMes).length() < 2 ? "0" + iMes : iMes) + "/" +
            iAnio 
        );
    }

    /**
     * Contructor con parametro en formato fecha.<br>
     * Formato segun sea el caracter que se encuentre en la fecha.
     * 
     * @param fecha <strong>fecha con formato. Ejemplo: dd/mm/aaaa.</strong>
     * @throws FechaNoValidaException Error - Formato no valido.
     */
    public Fecha(String fecha) throws FechaNoValidaException {
        if (formatoValido(fecha)) {
            String[] params = fecha.split("[\\._\\/-]");
            formatoCaracter = fecha.substring(2, 3);
            this.iDia = Integer.parseInt(params[0]);
            this.iMes = Integer.parseInt(params[1]);
            this.iAnio = Integer.parseInt(params[2]);
            validaFecha();
        } else {
            mensajesThrows("Formato no valido para [" + fecha + "]. Formatos esperados[dd/mm/aaaa | dd-mm-aaaa | dd_mm_aaaa].");
        }
    }


    // AGREGAR MAS METODOS AQUI PUBLICOS, YA SEA COMO AGREGAR DIAS, MESES Y AÑOS Y TAMBIEN 
    // QUITAR DIAS, MESES Y AÑOS(PARA QUITAR AÑOS ES NECESARIO METER LOS BISIESTOS DEL SIGLO PASADO)
    // QUE PUEDA CAMBIAR EL CARACTER POR DEFAULT A UNO PROPIO

    // Cambiar de caracter para el formato de la fecha
    /**
     * Asigna el caracter que el usuario registre, pero solo acepta 4 caracteres:
     * <ul>
     * <li>diagonal - <strong>/</strong></li>
     * <li>guion medio - <strong>-</strong></li>
     * <li>guion bajo - <strong>_</strong></li>
     * <li>punto - <strong>.</strong></li>
     * </ul>
     * 
     * @param caracter - Caracter a cambiar en la fecha (.-_/).
     * @throws FechaNoValidaException - Error - Caracter invalido.
     * @return
     *         <ul>
     *         <li>Parametro - <strong>caracter</strong></li>
     *         <li>Tipo - <strong>new Fecha</strong></li>
     *         </ul>
     */
    public Fecha asignaCaracter(String caracter) throws FechaNoValidaException {
        String expReg = "[\\._\\/-]";
        if (Pattern.matches(expReg, caracter.trim())) {
            return new Fecha(addZero(String.valueOf(getiDia())) + caracter + addZero(String.valueOf(getiMes()))
                    + caracter + String.valueOf(getiAnio()));
        } else {
            mensajesThrows("El car\u00e1cter que introdujo no es reconocido.");
            return null;
        }
    }

    /**
     * Obtiene el valor de la fecha con posibles formatos:
     * <ul>
     * <li><strong>31/01/1899. </strong></li>
     * <li><strong>31-01-1899. </strong></li>
     * <li><strong>31_01_1899. </strong></li>
     * <li><strong>31.01.1899. </strong></li>
     * </ul>
     */
    @Override
    public String toString() {
        return addZero(String.valueOf(getiDia())) + formatoCaracter + addZero(String.valueOf(getiMes())) + formatoCaracter
                + addZero(String.valueOf(getiAnio()));
    }


    // Validar formato valido para fecha
    private boolean formatoValido(String fec) {
        final String expReg = "\\d{1,2}[\\._\\/-]\\d{1,2}[\\._\\/-]\\d{4}";
        return Pattern.matches(expReg, fec);
    }
    // Validar si el año es bisiesto
    private boolean anioBisiesto() {
        return new ArrayList<>(Arrays.asList(ANIO_BISIESTO_SIGLO_XXI)).contains(String.valueOf(getiAnio()));
    }
    // Validaciones de fecha
    protected void validaFecha() throws FechaNoValidaException {
        if (iMes > 0 && iMes <= 12) {
            if (anioBisiesto() && iMes == 2) {
                if (iDia > 29) {
                    mensajesThrows(
                        "El n\u00famero de d\u00edas esta fuera de rango para el mes de " + NOMBRE_DEL_MES[iMes - 1] +
                        ", este mes tiene 29 d\u00edas y usted asigno " + getiDia() + ".");
                }
            } else {
                if (iDia > DIAS_DEL_MES[iMes - 1]) {
                    mensajesThrows(
                        "El n\u00famero de d\u00edas esta fuera de rango para el mes de " + NOMBRE_DEL_MES[iMes - 1] + 
                        ", este mes tiene " + DIAS_DEL_MES[iMes - 1] + " d\u00edas y usted asigno " + getiDia() + ".");
                }
            }
        } else {
            mensajesThrows("Valor [" + getiMes() + "] no valido para el mes. Valores esperados del 1 al 12.");
        }
    }



    // Setters and Getters...

    /**
     * Establece el valor del dia en el atributo <strong>[iDia].</strong>
     * 
     * @param iDia <strong>Numero del dia que se asignara.</strong>
     * @throws FechaNoValidaException Error - el dia esta fuera de rango o no
     *                                concuerda con el numero de dias del mes.
     */
    public void setiDia(int iDia) throws FechaNoValidaException {
        validaFecha();
        this.iDia = iDia;
    }

    /**
     * Obtiene el valor del dia.
     * 
     * @return
     *         <ul>
     *         <li>Parametro - <strong>iDia</strong></li>
     *         <li>Tipo - <strong>int</strong></li>
     *         </ul>
     */
    public int getiDia() {
        return iDia;
    }

    /**
     * Establece el valor del mes en el atributo <strong>[iMes].</strong>
     * 
     * @param iMes <strong>Numero del mes que se asignara.</strong>
     * @throws FechaNoValidaException Error - el mes esta fuera de rango.
     */
    public void setiMes(int iMes) throws FechaNoValidaException {
        validaFecha();
        this.iMes = iMes;
    }

    /**
     * Obtiene el valor del mes.
     * 
     * @return
     *         <ul>
     *         <li>Parametro - <strong>iMes</strong></li>
     *         <li>Tipo - <strong>int</strong></li>
     *         </ul>
     */
    public int getiMes() {
        return iMes;
    }

    /**
     * Establece el valor del año en el atributo <strong>[iAnio].</strong>
     * 
     * @param iAnio <strong>Numero de año que se asignara.</strong>
     * @throws FechaNoValidaException Error - el año no concuerda con la fecha 
     *                                signada y/o es bisiesto.
     */
    public void setiAnio(int iAnio) throws FechaNoValidaException {
        validaFecha();
        this.iAnio = iAnio;
    }

    /**
     * Obtiene el valor del año.
     * 
     * @return
     *         <ul>
     *         <li>Parametro - <strong>iAnio</strong></li>
     *         <li>Tipo - <strong>int</strong></li>
     *         </ul>
     */
    public int getiAnio() {
        return iAnio;
    }
}