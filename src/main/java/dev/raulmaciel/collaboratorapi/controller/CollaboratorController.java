package dev.raulmaciel.collaboratorapi.controller;

import dev.raulmaciel.collaboratorapi.dto.CollaboratorDto;
import dev.raulmaciel.collaboratorapi.entity.Collaborator;
import dev.raulmaciel.collaboratorapi.repository.CollaboratorRepository;
import dev.raulmaciel.collaboratorapi.service.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/collaborators")
public class CollaboratorController {
    private CollaboratorService collaboratorService;

    @Autowired
    public CollaboratorController(CollaboratorService collaboratorService) {
        this.collaboratorService = collaboratorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CollaboratorDto createCollaborator(@RequestBody final Collaborator collaborator){
       return collaboratorService.createCollaborator(collaborator);
    }
}
