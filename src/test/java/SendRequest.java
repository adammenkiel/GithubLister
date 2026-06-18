import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;
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
        for(Repository repository : requestService.getNotForkedRepositoryList("adammenkiel")) {
            System.out.println(repository.getRepositoryName());
        }
    }
}
