package aiss.bitbucketminer.model;

import aiss.bitbucketminer.etl.CommitTransformer;
import aiss.bitbucketminer.model.dependencies.*;
import aiss.bitbucketminer.model.dependencies.links.Links_Commit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketCommit {
    @JsonProperty("hash")
    private String id;
    private String title;
    @JsonProperty("message")
    private String message;
    private String author_name;
    private String author_email;
    @JsonProperty("date")
    private String authored_date;
    private String web_url;
    @JsonProperty("author")
    private Author author;
    @JsonProperty("summary")
    private Content summary;
    @JsonProperty("links")
    private Links_Commit links;

    public String getRaw() {
        return summary != null ? summary.getRaw() : null;
    }

    public String getTitle() {
        return summary != null ? summary.getRaw() : null;
    }

    public String getAuthor_name() {
        Pair<String, String> nameAndEmail = CommitTransformer.parserContact(author.getRaw());
        return nameAndEmail.getFirst();
    }

    public String getAuthor_email() {
        Pair<String, String> nameAndEmail = CommitTransformer.parserContact(author.getRaw());
        return nameAndEmail.getSecond();
    }

    public String getWeb_url() {
        return links != null ? links.getSelf().getHref() : null;
    }

}
