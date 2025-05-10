package aiss.gitminer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Commit")
public class Commit {

    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Project project;

    @JsonProperty("message")
    @Column(columnDefinition="TEXT")
    private String message;
    @JsonProperty("author_name")
    @NotEmpty(message = "Author name cannot be empty.")
    private String authorName;
    @JsonProperty("author_email")
    private String authorEmail;
    @JsonProperty("authored_date")
    @NotEmpty(message = "Author date cannot be empty.")
    private String authoredDate;

    @JsonProperty("web_url")
    @NotEmpty(message = "URL cannot be empty.")
    private String webUrl;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Commit.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null) ? "<null>" : this.title));
        sb.append(',');
        sb.append("message");
        sb.append('=');
        sb.append(((this.message == null) ? "<null>" : this.message));
        sb.append(',');
        sb.append("authorName");
        sb.append('=');
        sb.append(((this.authorName == null) ? "<null>" : this.authorName));
        sb.append(',');
        sb.append("authorEmail");
        sb.append('=');
        sb.append(((this.authorEmail == null) ? "<null>" : this.authorEmail));
        sb.append(',');
        sb.append("authoredDate");
        sb.append('=');
        sb.append(((this.authoredDate == null) ? "<null>" : this.authoredDate));
        sb.append(',');
        sb.append("webUrl");
        sb.append('=');
        sb.append(((this.webUrl == null) ? "<null>" : this.webUrl));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}