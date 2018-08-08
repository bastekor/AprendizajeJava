package bastekor.fechas.hora;

import java.time.LocalDateTime;
import java.util.regex.Pattern;
import bastekor.fechas.exceptions.FechaNoValidaException;

/**
 * <h3><strong>Clase Hora</strong></h3><br>
 * <h4><strong><u>Objetivo:</u></strong></h4><br>
 * Permite generar la hora de una manera facil y entendible de la siguiente
 * manera:<br>
 * <ul>
 * <li>Instancia de Hora - <strong>new Hora();</strong></li>
 * <li>Esperando hora, minuto y segundo (numerico) - <strong>new Hora(12, 6, 18);</strong></li>
 * <li>Esperando fecha con formato
 * <ul>
 * <li>dd/mm/aaaa - <strong>new Fecha("12:06:18");</strong></li>
 * </ul>
 * </li>
 * <li>Hora actual - <strong>Desde que se crea la instancia ya esta
 * inicializada la hora actual</strong></li>
 * </ul>
 * 
 * @author LEDZ
 * @version 1.0
 */

public class Hora extends FechaNoValidaException {

    private static final long serialVersionUID =1L;

    /**
     * Hora del dia
     */
    private int iHora;

    /**
     * Minuto del dia
     */
    private int iMinuto;

    /**
     * Segundo del dia
     */
    private int iSegundo;

    // Contructores

    /**
     * Constructor por default, se inicializa con la hora actual.<br>
     * Formato por defecto <strong>hh:mm:ss.</strong>
     */
    public Hora() {
        LocalDateTime hoy = LocalDateTime.now();
        this.iHora = hoy.getHour();
        this.iMinuto = hoy.getMinute();
        this.iSegundo = hoy.getSecond();
    }

    /**
     * Constructor con parametros hora, minuto y segundo.<br>
     * Formato por defecto <strong>hh:mm:ss.</strong>
     * 
     * @param iHora    <strong>Hora de la hora.</strong>
     * @param iMinuto  <strong>Minuto de la hora.</strong>
     * @param iSegundo <strong>Segundo de la hora.</strong>
     * @throws FechaNoValidaException Error - el formato y/o la hora no son validas.
     */
    public Hora(int iHora, int iMinuto, int iSegundo) throws FechaNoValidaException {
        this(
            (String.valueOf(iHora).length() < 2 ? "0" + iHora : iHora) + ":" +
            (String.valueOf(iMinuto).length() < 2 ? "0" + iMinuto : iMinuto) + ":" +
            (String.valueOf(iSegundo).length() < 2 ? "0" + iSegundo : iSegundo)
        );
    }

    /**
     * Contructor con parametro en formato fecha.<br>
     * Formato segun sea el caracter que se encuentre en la fecha.
     * 
     * @param hora <strong>hora con formato. Ejemplo: hh:mm:ss.</strong>
     * @throws FechaNoValidaException Error - Formato no valido.
     */
    public Hora(String hora) throws FechaNoValidaException {
        if (validaFormato(hora)) {
            String[] params = hora.split(":");
            this.iHora = Integer.parseInt(params[0]);
            this.iMinuto = Integer.parseInt(params[1]);
            this.iSegundo = Integer.parseInt(params[2]);
            validaRangos();
        } else {
            mensajesThrows("Formato no valido para [" + hora + "]. Formato esperado[hh:mm:ss].");
        }
    }


    /**
     * Obtiene el valor de la hora con formato <strong>hh:mm:ss.</strong>
     */
    @Override
    public String toString() {
        return String.format("%02d", getiHora()) + ":" + String.format("%02d", getiMinuto()) + ":" + String.format("%02d", getiSegundo());
    }

    // Validar formato valido para horas
    private boolean validaFormato(String hrs) {
        String expReg = "\\d{1,2}[:]\\d{1,2}[:]\\d{1,2}";
        return Pattern.matches(expReg, hrs);
    }

    // Validar rangos de horas[24], minutos[59] y segundos[59]
    private void validaRangos() throws FechaNoValidaException {
        if (!(iHora > -1 && iHora <= 24)) {
            mensajesThrows("Valor para la hora fuera de rango. Valor m\u00e1ximo 24 y usted asign\u00f3 " + iHora + ".");
        }
        if (!(iMinuto > -1 && iMinuto <= 59)) {
            mensajesThrows("Valor para el minuto fuera de rango. Valor m\u00e1ximo 59 y usted asign\u00f3 " + iMinuto + ".");
        }
        if (!(iSegundo > -1 && iSegundo <= 59)) {
            mensajesThrows("Valor para el segundo fuera de rango. Valor m\u00e1ximo 59 y usted asign\u00f3 " + iSegundo + ".");
        }
        // Si la hora esta en 24 - minutos y segundos deben de ser 0, en caso contrario error
        if (iHora == 24) {
            if (iMinuto != 0 || iSegundo != 0) {
                mensajesThrows("Los segundos y/o minutos se han pasado del rango del formato ha 24hrs." + 
                " El formato como m\u00e1ximo debe ser 24:00:00 no " + iHora + ":" + iMinuto + ":" + iSegundo + ".");
            }
        }
    }

    // Setters and Getters...

    /**
     * Establece el valor del dia en el atributo <strong>[iHora].</strong>
     * 
     * @param iHora <strong>Numero de la hora que se asignara.</strong>
     * @throws FechaNoValidaException Error - la hora esta fuera de rango.
     */
    public void setiHora(int iHora) throws FechaNoValidaException {
        validaRangos();
        this.iHora = iHora;
    }

    /**
     * Obtiene el valor de la hora.
     * 
     * @return
     *         <ul>
     *         <li>Parametro - <strong>iHora</strong></li>
     *         <li>Tipo - <strong>int</strong></li>
     *         </ul>
     */
    public int getiHora() {
        return iHora;
    }

    /**
     * Establece el valor del minuto en el atributo <strong>[iMinuto].</strong>
     * 
     * @param iMinuto <strong>Numero del minuto que se asignara.</strong>
     * @throws FechaNoValidaException Error - el minuto esta fuera de rango.
     */
    public void setiMinuto(int iMinuto) throws FechaNoValidaException {
        validaRangos();
        this.iMinuto = iMinuto;
    }

    /**
     * Obtiene el valor del minuto.
     * 
     * @return
     *         <ul>
     *         <li>Parametro - <strong>iMinuto</strong></li>
     *         <li>Tipo - <strong>int</strong></li>
     *         </ul>
     */
    public int getiMinuto() {
        return iMinuto;
    }

    /**
     * Establece el valor del segundo en el atributo <strong>[iSegundo].</strong>
     * 
     * @param iSegundo <strong>Numero de segundo que se asignara.</strong>
     * @throws FechaNoValidaException Error - el Segundo esta fuera de rango [0-59].
     */
    public void setiSegundo(int iSegundo) throws FechaNoValidaException {
        validaRangos();
        this.iSegundo = iSegundo;
    }

    /**
     * Obtiene el valor del segundo.
     * 
     * @return
     *         <ul>
     *         <li>Parametro - <strong>iSegundo</strong></li>
     *         <li>Tipo - <strong>int</strong></li>
     *         </ul>
     */
    public int getiSegundo() {
        return iSegundo;
    }
}