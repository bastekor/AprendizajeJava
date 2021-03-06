package bastekor.fechas.exceptions;

/**
 * <h3><strong>Clase FechaNoValidaException</strong></h3><br>
 * <h4><strong><u>Objetivo:</u></strong></h4><br>
 * Envia mensajes de respuesta a posibles errores en la creacion de fechas.
 *
 * @author LEDZ
 * @version 1.0
 */
public class FechaNoValidaException extends Exception {

    private static final long serialVersionUID = 1L;
    public FechaNoValidaException(){}

    public FechaNoValidaException(String mensaje) {
        super(mensaje);
    }

    // Mensajes de errores
    protected void mensajesThrows(String msj) throws FechaNoValidaException {
        throw new FechaNoValidaException(msj);
    }
}