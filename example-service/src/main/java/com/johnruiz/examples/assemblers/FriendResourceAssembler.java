package com.johnruiz.examples.assemblers;

import com.johnruiz.examples.Friend;
import com.johnruiz.examples.controllers.FriendsController;
import com.johnruiz.examples.resources.FriendResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

/**
 * Created by jar349 on 1/23/15.
 */
@Component
public class FriendResourceAssembler extends ResourceAssemblerSupport<Friend, FriendResource> {

    public FriendResourceAssembler() {
        super(FriendsController.class, FriendResource.class);
    }


    @Override
    public FriendResource toResource(Friend entity) {

        // create the resource with a link to itself
        FriendResource friendResource = createResourceWithId(entity.getId(), entity);

        // set its values
        friendResource.setFriendId(entity.getId());
        friendResource.setFirstName(entity.getFirstName());
        friendResource.setLastName(entity.getLastName());

        return friendResource;
    }

    @Override
    protected FriendResource instantiateResource(Friend friend) {
        return FriendResource.from(friend);
    }
}
