package aiss.bitbucketminer.model.containers;

import aiss.bitbucketminer.model.BitBucketComment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BitBucketCommentContainer {
    @JsonProperty("values")
    private List<BitBucketComment> comments;
}
