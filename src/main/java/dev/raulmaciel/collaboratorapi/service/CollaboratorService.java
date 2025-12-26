package dev.raulmaciel.collaboratorapi.service;

import dev.raulmaciel.collaboratorapi.dto.CollaboratorDto;
import dev.raulmaciel.collaboratorapi.dto.mapper.CollaboratorMapper;
import dev.raulmaciel.collaboratorapi.entity.Collaborator;
import dev.raulmaciel.collaboratorapi.repository.CollaboratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorService {
    private final CollaboratorRepository collaboratorRepository;
    private final CollaboratorMapper collaboratorMapper;

    @Autowired
    public CollaboratorService(CollaboratorRepository collaboratorRepository, CollaboratorMapper collaboratorMapper) {
        this.collaboratorRepository = collaboratorRepository;
        this.collaboratorMapper = collaboratorMapper;
    }

    public CollaboratorDto createCollaborator(Collaborator collaborator) {
        Collaborator savedCollaborator = collaboratorRepository.save(collaborator);
        return collaboratorMapper.toDto(savedCollaborator);
    }
}
