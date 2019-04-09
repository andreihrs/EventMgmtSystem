package com.fmi.project.event;

import com.fmi.project.location.Location;

import java.util.Date;

public class PrivateEvent extends Event {

    private boolean requiresInvitation;
    private boolean canInviteFriend;

    public PrivateEvent(Location location, Date startEvent, Date endEvent, boolean isFree, String eventName, boolean requiresInvitation, boolean canInviteFriend) {
        super(location, startEvent, endEvent, isFree, eventName);
        this.requiresInvitation = requiresInvitation;
        this.canInviteFriend = canInviteFriend;
    }

    public PrivateEvent(boolean requiresInvitation, boolean canInviteFriend) {
        this.requiresInvitation = requiresInvitation;
        this.canInviteFriend = canInviteFriend;
    }

    public PrivateEvent() {
    }

    public boolean isRequiresInvitation() {
        return requiresInvitation;
    }

    public void setRequiresInvitation(boolean requiresInvitation) {
        this.requiresInvitation = requiresInvitation;
    }

    public boolean isCanInviteFriend() {
        return canInviteFriend;
    }

    public void setCanInviteFriend(boolean canInviteFriend) {
        this.canInviteFriend = canInviteFriend;
    }
}
