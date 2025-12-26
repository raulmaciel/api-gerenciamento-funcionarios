package dev.raulmaciel.collaboratorapi.controller;

import dev.raulmaciel.collaboratorapi.dto.request.CollaboratorDto;
import dev.raulmaciel.collaboratorapi.dto.response.MessageResponseDto;
import dev.raulmaciel.collaboratorapi.entity.Collaborator;
import dev.raulmaciel.collaboratorapi.exception.CollaboratorNotFoundException;
import dev.raulmaciel.collaboratorapi.service.CollaboratorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<CollaboratorDto> listAll(){
        return collaboratorService.listAll();
    }

    @GetMapping("/{id}")
    public CollaboratorDto findById(@PathVariable Long id) throws CollaboratorNotFoundException {
        return collaboratorService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws CollaboratorNotFoundException {
        collaboratorService.deleteById(id);
    }
}
