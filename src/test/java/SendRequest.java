import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;
import pl.publicprojects.githublister.basic.Branch;
import pl.publicprojects.githublister.basic.Repository;
import pl.publicprojects.githublister.basic.RequestService;

import java.util.List;

public class SendRequest {
    public static void main(String[] args) {
        RequestService requestService = new RequestService();
        for(Repository repository : requestService.getRepositoryList("adammenkiel")) {
            System.out.println(repository.getRepositoryName() + " - Forked: " + repository.isFork());
        }
        System.out.println("Without forks:");
        String username = "adammenkiel";
        for(Repository repository : requestService.getNotForkedRepositoryList(username)) {
            System.out.println(repository.getRepositoryName() + " - ");
            for(Branch branch : requestService.getBranchList(username, repository.getRepositoryName())) {
                System.out.println(branch.getBranchName() + " " + branch.getCommit().getSha() + " " + branch.getCommit().getUrl());
            }
        }
    }
}
