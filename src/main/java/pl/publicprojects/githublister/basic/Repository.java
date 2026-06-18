package pl.publicprojects.githublister.basic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Repository {
    @JsonProperty("fork")
    private boolean fork;
    @JsonProperty("name")
    private String repositoryName;
}
