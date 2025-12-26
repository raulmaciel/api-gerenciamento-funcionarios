package dev.raulmaciel.collaboratorapi.service;

import dev.raulmaciel.collaboratorapi.dto.mapper.CollaboratorMapper;
import dev.raulmaciel.collaboratorapi.dto.request.CollaboratorDto;
import dev.raulmaciel.collaboratorapi.dto.response.MessageResponseDto;
import dev.raulmaciel.collaboratorapi.entity.Collaborator;
import dev.raulmaciel.collaboratorapi.exception.CollaboratorNotFoundException;
import dev.raulmaciel.collaboratorapi.repository.CollaboratorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CollaboratorService {
    private final CollaboratorRepository collaboratorRepository;
    private final CollaboratorMapper collaboratorMapper = CollaboratorMapper.INSTANCE;

    @Autowired
    public CollaboratorService(CollaboratorRepository collaboratorRepository) {
        this.collaboratorRepository = collaboratorRepository;
    }

    @Transactional
    public MessageResponseDto createCollaborator(CollaboratorDto collaboratorDto) {
        Collaborator collaboratorToSave = collaboratorMapper.toModel(collaboratorDto);
        Collaborator savedCollaborator = collaboratorRepository.save(collaboratorToSave);

        return MessageResponseDto.builder()
                .message("Created collaborator with ID " + savedCollaborator.getId())
                .build();
    }

    @Transactional
    public List<CollaboratorDto> listAll(){
        List<Collaborator> collaborators = collaboratorRepository.findAll();
        return collaborators.stream().map(collaboratorMapper::toDTO).toList();
    }

    @Transactional
    public CollaboratorDto findById(Long id) throws CollaboratorNotFoundException {
        Collaborator collaborator = collaboratorRepository.findById(id).orElseThrow(() -> new CollaboratorNotFoundException(id));
        return collaboratorMapper.toDTO(collaborator);
    }


}
