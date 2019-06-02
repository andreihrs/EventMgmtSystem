package com.fmi.project.event;

import com.fmi.project.client.Client;

import java.util.Date;

public class PrivateEvent extends Event {

    private boolean requiresInvitation;

    public PrivateEvent(Client client, Date startEvent, String eventName, boolean isFree, boolean requiresInvitation) {
        super(client, startEvent, eventName, isFree);
        this.requiresInvitation = requiresInvitation;
    }

    public PrivateEvent(boolean requiresInvitation, boolean canInviteFriend) {
        this.requiresInvitation = requiresInvitation;
    }

    public PrivateEvent() {
    }

    public boolean isRequiresInvitation() {
        return requiresInvitation;
    }

    public void setRequiresInvitation(boolean requiresInvitation) {
        this.requiresInvitation = requiresInvitation;
    }
}
