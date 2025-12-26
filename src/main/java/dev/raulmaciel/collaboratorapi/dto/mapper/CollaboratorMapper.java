package dev.raulmaciel.collaboratorapi.dto.mapper;

import dev.raulmaciel.collaboratorapi.dto.CollaboratorDto;
import dev.raulmaciel.collaboratorapi.entity.Collaborator;
import org.springframework.stereotype.Component;

@Component
public class CollaboratorMapper {
    public CollaboratorDto toDto(Collaborator collaborator){
        return new CollaboratorDto(collaborator.getFirstName(),
                collaborator.getLastName(),
                collaborator.getCpf(),
                collaborator.getBirthDate(),
                collaborator.getPhones());
    }
}
