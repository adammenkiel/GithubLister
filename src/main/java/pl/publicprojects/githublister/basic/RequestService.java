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
                .uri("https://api.github.com/users/" + username + "/repos")
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }

    public List<Branch> getBranchList(String username, String repository) {
        RestClient restClient = RestClient.create();
        return restClient.get()
                .uri("https://api.github.com/repos/" + username + "/" + repository + "/branches")
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }

    public List<Repository> getNotForkedRepositoryList(String username) {
        List<Repository> repoList = this.getRepositoryList(username)
                .stream()
                .filter(repo -> !repo.isFork())
                .toList();

        for(Repository repo : repoList) {
            repo.setBranches(
                    this.getBranchList(username, repo.getRepositoryName())
            );
        }

        return repoList;
    }


}
