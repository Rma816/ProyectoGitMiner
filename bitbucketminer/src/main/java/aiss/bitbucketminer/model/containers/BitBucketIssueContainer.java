package aiss.bitbucketminer.model.containers;

import aiss.bitbucketminer.model.BitBucketIssue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BitBucketIssueContainer {
    @JsonProperty("values")
    private List<BitBucketIssue> issues;
}
