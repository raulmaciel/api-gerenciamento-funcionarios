package dev.raulmaciel.collaboratorapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CollaboratorNotFoundException extends Exception{

    public CollaboratorNotFoundException(Long id) {
        super("Collaborator not found with id: " + id);
    }
}
