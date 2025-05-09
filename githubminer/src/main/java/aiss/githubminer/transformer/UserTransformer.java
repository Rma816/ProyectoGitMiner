package aiss.githubminer.transformer;

import aiss.githubminer.model.UserGHM;
import aiss.gitminer.model.User;

public class UserTransformer {

    public static User transformer(UserGHM gitHubUser) {
        User user = new User();
        user.setId(String.valueOf(gitHubUser.getId()));
        user.setUsername(gitHubUser.getLogin());
        user.setName(gitHubUser.getLogin());
        user.setAvatarUrl(gitHubUser.getUrl());
        user.setWebUrl(gitHubUser.getUrl());
        return user;
    }

}
