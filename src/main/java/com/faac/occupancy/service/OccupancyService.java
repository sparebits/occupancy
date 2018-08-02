package com.faac.occupancy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faac.occupancy.model.Occupancy;
import com.faac.occupancy.model.Response;

@RestController
public class OccupancyService {
    
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @RequestMapping("/occupancy")
    public Response pushOccupancy(Occupancy occupancy) {
        logger.info("pushing occupancy...");
        return new Response();
    }

}
