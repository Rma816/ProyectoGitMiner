package aiss.bitbucketminer.model.dependencies;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Content {
    private String type;
    private String raw;
    private String markup;
    private String html;
}


