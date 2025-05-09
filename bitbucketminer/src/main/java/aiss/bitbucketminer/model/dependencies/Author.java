package aiss.bitbucketminer.model.dependencies;

import aiss.bitbucketminer.model.BitBucketUser;
import lombok.Data;

@Data
public class Author {
    private String type;
    private String raw;
    private BitBucketUser user;
}
