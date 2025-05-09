package aiss.bitbucketminer.etl;

import aiss.bitbucketminer.model.BitBucketUser;
import aiss.gitminer.model.User;

public class UserTransformer {

    public static User transformUser (BitBucketUser user) {
        if (user == null) {
            return null;
        }
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setName(user.getName());
        newUser.setUsername(user.getUsername());
        newUser.setAvatarUrl(user.getAvatar_url());
        newUser.setWebUrl(user.getWeb_url());
        return newUser;
    }
}
