package aiss.bitbucketminer.model.containers;

import aiss.bitbucketminer.model.BitBucketCommit;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BitBucketCommitContainer {
    @JsonProperty("values")
    private List<BitBucketCommit> commits;
}
