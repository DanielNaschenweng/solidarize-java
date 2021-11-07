package org.hackamarte.impact.exception;

import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe para armazenar os dados de exessão que será retornada
 */
@Getter
public class ExceptionResponse implements Serializable {
    private Date timestamp;
    private String message;
    private String details;

    /**
     * Inicializa a execessão
     *
     * @param timestamp Data e hora da excessão
     * @param message   Mensagem da exessão
     * @param details   Detalhes da excessão
     */
    public ExceptionResponse(Date timestamp, String message, String details) {

        this.timestamp = timestamp;
        this.message = message;
        this.details = details;

    }
}
