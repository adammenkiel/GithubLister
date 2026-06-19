package pl.publicprojects.githublister.basic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectsController {

    private final RequestService requestService = new RequestService();

    @GetMapping("/projects/{username}")
    public ResponseEntity<?> getProjects(@PathVariable String username) {
        return ResponseEntity.ok(this.requestService.getNotForkedRepositoryList(username));
    }
}
