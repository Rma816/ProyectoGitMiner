package aiss.githubminer.model.projectD;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectPermissions {

    @JsonProperty("admin")
    private Boolean admin;
    @JsonProperty("push")
    private Boolean push;
    @JsonProperty("pull")
    private Boolean pull;

    @JsonProperty("admin")
    public Boolean getAdmin() {
        return admin;
    }

    @JsonProperty("admin")
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @JsonProperty("push")
    public Boolean getPush() {
        return push;
    }

    @JsonProperty("push")
    public void setPush(Boolean push) {
        this.push = push;
    }

    @JsonProperty("pull")
    public Boolean getPull() {
        return pull;
    }

    @JsonProperty("pull")
    public void setPull(Boolean pull) {
        this.pull = pull;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ProjectPermissions.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("admin");
        sb.append('=');
        sb.append(((this.admin == null)?"<null>":this.admin));
        sb.append(',');
        sb.append("push");
        sb.append('=');
        sb.append(((this.push == null)?"<null>":this.push));
        sb.append(',');
        sb.append("pull");
        sb.append('=');
        sb.append(((this.pull == null)?"<null>":this.pull));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
