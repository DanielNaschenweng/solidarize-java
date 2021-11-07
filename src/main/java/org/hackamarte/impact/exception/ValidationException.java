package org.hackamarte.impact.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Classe de excessão de validação.
 * Utilizada para causar uma exessão se uma regra de validação não for cumprida
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException{
    /**
     * Inicializa a excessão
     *
     * @param exception Excessão
     */
    public ValidationException(String exception){
        super(exception);
    }
}
