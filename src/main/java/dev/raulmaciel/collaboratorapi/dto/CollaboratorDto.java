package dev.raulmaciel.collaboratorapi.dto;

import dev.raulmaciel.collaboratorapi.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public record CollaboratorDto(String firstName,
                              String lastName,
                              String cpf,
                              LocalDate birthDate,
                              List<Phone> phones) {
}
