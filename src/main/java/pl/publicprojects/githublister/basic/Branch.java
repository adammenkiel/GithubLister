package pl.publicprojects.githublister.basic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Branch {

    @Getter
    public static class Commit {
        @JsonProperty("sha")
        String sha;
        @JsonProperty("url")
        String url;
    }

    @JsonProperty("name")
    private String branchName;
    @JsonProperty("commit")
    private Commit commit;
}
