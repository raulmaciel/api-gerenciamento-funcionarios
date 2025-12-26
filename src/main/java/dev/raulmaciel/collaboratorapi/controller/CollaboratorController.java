package dev.raulmaciel.collaboratorapi.controller;

import dev.raulmaciel.collaboratorapi.dto.request.CollaboratorDto;
import dev.raulmaciel.collaboratorapi.dto.response.MessageResponseDto;
import dev.raulmaciel.collaboratorapi.entity.Collaborator;
import dev.raulmaciel.collaboratorapi.service.CollaboratorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public MessageResponseDto createCollaborator(@RequestBody @Valid final CollaboratorDto collaboratorDto){
       return collaboratorService.createCollaborator(collaboratorDto);
    }
}
