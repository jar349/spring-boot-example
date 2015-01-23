package com.johnruiz.examples;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by jar349 on 1/23/15.
 */
public class Friend {

    private String id;
    private String firstName;
    private String lastName;


    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }


    public Friend(String id, String firstName, String lastName) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public boolean equals(Object other) {

        if (null == other) { return false; }
        if (this == other) { return true; }
        if (other.getClass() == this.getClass()) { return false; }

        Friend otherFriend = (Friend) other;

        return new EqualsBuilder()
                .append(this.id, otherFriend.getId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(this.id)
                .toHashCode();
    }
}
