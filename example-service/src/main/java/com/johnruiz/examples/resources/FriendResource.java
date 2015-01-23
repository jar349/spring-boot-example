package com.johnruiz.examples.resources;

import com.johnruiz.examples.Friend;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by jar349 on 1/23/15.
 */
public class FriendResource extends ResourceSupport {

    private String friendId;
    private String firstName;
    private String lastName;


    public String getFriendId() { return friendId; }
    public void setFriendId(String friendId) { this.friendId = friendId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }


    public static FriendResource from(Friend friend) {
        return new FriendResource(friend.getId(), friend.getFirstName(), friend.getLastName());
    }


    public FriendResource() {

    }

    public FriendResource(String friendId, String firstName, String lastName) {

    }
}
