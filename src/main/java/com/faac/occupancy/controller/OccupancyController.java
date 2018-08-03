/**
 * 
 */
package com.faac.occupancy.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.faac.occupancy.model.HelloMessage;
import com.faac.occupancy.model.Occupancy;

/**
 * @author nneikov
 */
@Controller
public class OccupancyController {
    
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Occupancy greeting(HelloMessage message) throws Exception {
        return new Occupancy(message.getName(), 0, 0);
    }

}
