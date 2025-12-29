package dev.raulmaciel.collaboratorapi.service;

import dev.raulmaciel.collaboratorapi.dto.mapper.CollaboratorMapper;
import dev.raulmaciel.collaboratorapi.dto.request.CollaboratorDto;
import dev.raulmaciel.collaboratorapi.dto.response.MessageResponseDto;
import dev.raulmaciel.collaboratorapi.entity.Collaborator;
import dev.raulmaciel.collaboratorapi.exception.CollaboratorNotFoundException;
import dev.raulmaciel.collaboratorapi.repository.CollaboratorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = @__(@Autowired))
public class CollaboratorService {
    private final CollaboratorRepository collaboratorRepository;
    private final CollaboratorMapper collaboratorMapper = CollaboratorMapper.INSTANCE;

    @Transactional
    public MessageResponseDto createCollaborator(CollaboratorDto collaboratorDto) {
        Collaborator collaboratorToSave = collaboratorMapper.toModel(collaboratorDto);
        Collaborator savedCollaborator = collaboratorRepository.save(collaboratorToSave);

        return createMessageResponse("Created collaborator with ID ", savedCollaborator.getId());
    }

    private static MessageResponseDto createMessageResponse(String message, Long id) {
        return MessageResponseDto.builder()
                .message(message + id)
                .build();
    }

    @Transactional
    public List<CollaboratorDto> listAll(){
        List<Collaborator> collaborators = collaboratorRepository.findAll();
        return collaborators.stream().map(collaboratorMapper::toDTO).toList();
    }

    @Transactional
    public CollaboratorDto findById(Long id) throws CollaboratorNotFoundException {
        Collaborator collaborator = verifyIfExists(id);
        return collaboratorMapper.toDTO(collaborator);
    }

    @Transactional
    public void deleteById(Long id) throws CollaboratorNotFoundException {
        verifyIfExists(id);
        collaboratorRepository.deleteById(id);
    }


    @Transactional
    public MessageResponseDto updateById(Long id, CollaboratorDto collaboratorDto) throws CollaboratorNotFoundException {
        verifyIfExists(id);
        Collaborator collaboratorToUpdate = collaboratorMapper.toModel(collaboratorDto);
        Collaborator updatedModel = collaboratorRepository.save(collaboratorToUpdate);
        return createMessageResponse("Updated collaborator with ID ", id);
    }


    private Collaborator verifyIfExists(Long id) throws CollaboratorNotFoundException {
        return collaboratorRepository.findById(id).orElseThrow(() -> new CollaboratorNotFoundException(id));
    }


}
