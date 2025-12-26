package dev.raulmaciel.collaboratorapi.repository;

import dev.raulmaciel.collaboratorapi.entity.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {

}
