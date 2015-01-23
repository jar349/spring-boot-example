package com.johnruiz.examples.controllers;

import com.johnruiz.examples.Friend;
import com.johnruiz.examples.assemblers.FriendResourceAssembler;
import com.johnruiz.examples.resources.FriendResource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jar349 on 1/23/15.
 */
@RestController
@RequestMapping("/friends")
public class FriendsController {

    private static final Log LOG = LogFactory.getLog(FriendsController.class);

    @Autowired
    private FriendResourceAssembler friendResourceAssembler;

    private HashMap<String, List<Friend>> friendRepository;


    public FriendsController() {
        friendRepository = new HashMap<>();

        List<Friend> friendList = new ArrayList<>();
        friendList.add(new Friend("123", "Richard", "Clayton"));

        friendRepository.put("john", friendList);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(method = RequestMethod.GET)
    public List<FriendResource> getFriends(@AuthenticationPrincipal User requestor) {

        String username = requestor.getUsername();
        LOG.debug(String.format("User '%s' is requesting their friends list.", username));

        List<Friend> friends;

        if (friendRepository.containsKey(username)) {
            friends = friendRepository.get(username);
        }
        else {
            friends = new ArrayList<>();
        }

        StringBuilder sb = new StringBuilder("Found the following friends: ");
        for (Friend f : friends) {
            sb.append("'");
            sb.append(f.getFirstName());
            sb.append(" ");
            sb.append(f.getLastName());
            sb.append(" (");
            sb.append(f.getId());
            sb.append(")' ");
        }
        LOG.debug(sb.toString().trim());

        return this.friendResourceAssembler.toResources(friends);
    }
}
