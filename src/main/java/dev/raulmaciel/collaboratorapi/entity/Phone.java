package dev.raulmaciel.collaboratorapi.entity;

import dev.raulmaciel.collaboratorapi.enums.PhoneType;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "phone_type")
    private PhoneType type;

    @Column(nullable = false, name = "number")
    private String number;
}
