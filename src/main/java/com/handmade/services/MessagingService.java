package com.handmade.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 * Created by Matt on 3/12/19.
 */
public class MessagingService {
    private final String AUTH_TOKEN = "815191b676e905ac7146936d2f5ce2c0";
    private final String ACCOUNT_SID = "AC92ad24397d79652a15c64e84c908dd42";

    public void messageTest() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber("+13016020293"),
                new PhoneNumber("+12405466409")
                ,
                "This is the ship that made the Kessel Run in fourteen parsecs?").create();

    }

}
