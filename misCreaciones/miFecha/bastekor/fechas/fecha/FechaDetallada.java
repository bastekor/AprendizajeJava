package bastekor.fechas.fecha;

import java.time.LocalDate;

import bastekor.fechas.exceptions.FechaNoValidaException;

public class FechaDetallada extends Fecha {

   private static final long serialVersionUID = 1L;

   private static String[] NOMBRE_DEL_DIA = {
       "Domingo", "Lunes", "Martes", "Miercoles",
       "Jueves", "Viernes", "Sabado"
   };
   
   private int iDiaDeLaSemana;

    // Contructores 
    
    /**
     * Constructor por default, se inicializa con la fecha actual.<br>
     * Formato por defecto <strong>dd/mm/aaaa.</strong>
     */
    public FechaDetallada() {
        super();
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
    public FechaDetallada(int iDia, int iMes, int iAnio) throws FechaNoValidaException {
        super(iDia, iMes, iAnio);
    }

    /**
     * Contructor con parametro en formato fecha.<br>
     * Formato segun sea el caracter que se encuentre en la fecha.
     * 
     * @param fecha <strong>fecha con formato. Ejemplo: dd/mm/aaaa.</strong>
     * @throws FechaNoValidaException Error - Formato no valido.
     */
    public FechaDetallada(String fecha) throws FechaNoValidaException {
        super(fecha);
    }

    /**
     * Obtiene el valor de la fecha con formato - <strong>Lunes 12 de Septiembre de 2002</strong>
     */
    @Override
    public String toString() {
        iDiaDeLaSemana =
        LocalDate.of(getiAnio(), getiMes(), getiDia()).getDayOfWeek().getValue();
        return NOMBRE_DEL_DIA[iDiaDeLaSemana] + ", " + addZero(String.valueOf(getiDia())) + " de " + NOMBRE_DEL_MES[getiMes() - 1] + " de " + getiAnio();
    }

}