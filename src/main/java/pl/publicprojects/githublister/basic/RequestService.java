package pl.publicprojects.githublister.basic;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RequestService {
    public List<Repository> getRepositoryList(String username) {
        RestClient restClient = RestClient.create();
        return restClient.get()
                .uri("https://api.github.com/users/"+username+"/repos")
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }

    public List<Repository> getNotForkedRepositoryList(String username) {
        return this.getRepositoryList(username).stream().filter(repo -> !repo.isFork()).toList();
    }
}
