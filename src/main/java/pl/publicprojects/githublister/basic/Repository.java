package pl.publicprojects.githublister.basic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class Repository {
    @JsonProperty("fork")
    private boolean fork;
    @JsonProperty("name")
    private String repositoryName;
    @Setter
    private List<Branch> branches;
}
