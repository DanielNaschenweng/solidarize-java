package org.hackamarte.solidarize.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Classe de sessão para registros encontrados que não deveriam existir.
 * Utilizada para quando de deseja persistir um dados que não pode existir no repositório
 */
@ResponseStatus(HttpStatus.FOUND)
public class FoundException extends RuntimeException{
    /**
     * Inicializa a excessão
     *
     * @param exception the excessão
     */
    public FoundException(String exception){
        super(exception);
    }
}
