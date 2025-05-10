package aiss.githubminer.transformer;

import aiss.githubminer.model.UserGHM;
import aiss.gitminer.model.User;

public class UserTransformer {

    public static User transformer(UserGHM gitHubUser) {
        User user = new User();
        user.setId(gitHubUser.getId() != null ? gitHubUser.getId().toString() : "No Id");
        user.setUsername(gitHubUser.getLogin() != null ? gitHubUser.getLogin() : "No Username");
        user.setName(gitHubUser.getLogin() != null ? gitHubUser.getLogin() : "No Name");
        user.setAvatarUrl(gitHubUser.getUrl() != null ? gitHubUser.getUrl() : "No Avatar Url");
        user.setWebUrl(gitHubUser.getUrl() != null ? gitHubUser.getUrl() : "No Web Url");
        return user;
    }

}
