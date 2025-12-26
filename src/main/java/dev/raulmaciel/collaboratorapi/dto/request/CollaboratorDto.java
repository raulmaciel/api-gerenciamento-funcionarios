package dev.raulmaciel.collaboratorapi.dto.request;

import dev.raulmaciel.collaboratorapi.entity.Phone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

public record CollaboratorDto(@NotEmpty @Size(min = 2, max = 100) String firstName,
                              @NotEmpty @Size(min = 2, max = 100)String lastName,
                              @NotEmpty @CPF String cpf,
                              String birthDate,
                              @NotEmpty @Valid List<Phone> phones) {
}
