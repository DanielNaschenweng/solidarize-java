package org.hackamarte.solidarize.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Classe de excessão para informações não localiadas.
 * Utilizada para retornar quando uma busca não encontra um dado.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    /**
     * Inicializa a excessão
     *
     * @param exception excessão
     */
    public NotFoundException(String exception){
        super(exception);
    }
}
