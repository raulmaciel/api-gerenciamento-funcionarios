package dev.raulmaciel.collaboratorapi.dto.request;

import dev.raulmaciel.collaboratorapi.enums.PhoneType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record PhoneDto(@Enumerated(EnumType.STRING) PhoneType type,
                       @NotEmpty @Size(min = 13, max = 14) String number) {
}
