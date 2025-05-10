package aiss.bitbucketminer.etl;

import aiss.bitbucketminer.model.BitBucketUser;
import aiss.gitminer.model.User;

public class UserTransformer {

    public static User transformUser (BitBucketUser user) {
        if (user == null) {
            return null;
        }
        User newUser = new User();
        newUser.setId(user.getId() != null ? user.getId() : "No user id");
        newUser.setName(user.getName() != null ? user.getName() : "No user name");
        newUser.setUsername(user.getUsername() != null ? user.getUsername() : "No user username");
        newUser.setAvatarUrl(user.getAvatar_url() != null ? user.getAvatar_url() : "No user avatar url");
        newUser.setWebUrl(user.getWeb_url() != null ? user.getWeb_url() : "No user web url");
        return newUser;
    }
}
