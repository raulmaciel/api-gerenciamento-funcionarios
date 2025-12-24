package dev.raulmaciel.collaboratorapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/collaborators")
public class CollaboratorController {
    public String getBook(){
        return "Api test";
    }
}
