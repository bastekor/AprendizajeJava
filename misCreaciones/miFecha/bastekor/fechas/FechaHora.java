package bastekor.fechas;

import bastekor.fechas.fecha.Fecha;
import bastekor.fechas.fecha.FechaDetallada;
import bastekor.fechas.hora.Hora;
import bastekor.fechas.exceptions.FechaNoValidaException;

public class FechaHora {
    
    public static String tomarFecha() {
        return new Fecha().toString();
    }

    public static String tomarFechaDetallada() {
        return new FechaDetallada().toString();
    }

    public static String tomarHora() {
        return new Hora().toString();
    }

    public static String tomarFechaConHora() {
        return new Fecha().toString() + " " + new Hora().toString();
    }

    public static String tomarFechaDetalladaConHora() {
        return new FechaDetallada().toString() + " " + new Hora().toString();
    }

    // Crear

    public static String crearFecha(int dia, int mes, int anio) throws FechaNoValidaException {
        return new Fecha(dia, mes, anio).toString();
    }

    public static String crearFecha(String fecha) throws FechaNoValidaException {
        return new Fecha(fecha).toString();
    }

    public static String crearFechaDetallada(int dia, int mes, int anio) throws FechaNoValidaException {
        return new FechaDetallada(dia, mes, anio).toString();
    }

    public static String crearFechaDetallada(String fecha) throws FechaNoValidaException {
        return new FechaDetallada(fecha).toString();
    }

    public static String crearHora(int hora, int minuto, int segundo) throws FechaNoValidaException {
        return new Hora(hora, minuto, segundo).toString();
    }

    public static String crearHora(String hora) throws FechaNoValidaException {
        return new Hora(hora).toString();
    }

    public static String crearFechaConHora(String fecha, String hora) throws FechaNoValidaException {
        return new Fecha(fecha).toString() + " " + new Hora(hora).toString();
    }

    public static String crearFechaDetalladaConHora(String fecha, String hora) throws FechaNoValidaException {
        return new FechaDetallada(fecha).toString() + " " + new Hora(hora).toString();
    }
}