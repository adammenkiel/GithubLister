import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

public class TestBranchRequest {
    public static void main(String[] args) {
        RestClient restClient = RestClient.create();
        String response = restClient.get()
                .uri("https://api.github.com/repos/adammenkiel/AEP")
                .retrieve()
                .body(String.class);
        System.out.println(response);
    }
}
