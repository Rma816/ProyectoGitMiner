package aiss.githubminer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String id;
    private String login;
    private String name;
    private String email;
    private String type;

    // Getters and setters
}