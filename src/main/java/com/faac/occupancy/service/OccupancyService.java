package com.faac.occupancy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faac.occupancy.dao.OccupancyRepository;
import com.faac.occupancy.model.Occupancy;
import com.faac.occupancy.model.Response;

@RestController
public class OccupancyService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private SimpMessagingTemplate template;
    
    @Autowired
    private OccupancyRepository occupancyRepository;

    @RequestMapping(value = "/occupancy", method = RequestMethod.PUT)
    public Response pushOccupancy(@RequestBody Occupancy occupancy) {
        logger.info("pushing occupancy...");
        com.faac.occupancy.domain.Occupancy domainOccupancy = occupancyRepository.findByParkingId(occupancy.getParkingId());
        
        if (domainOccupancy == null) {
            domainOccupancy = new com.faac.occupancy.domain.Occupancy(occupancy.getParkingId(), occupancy.getTotalPlaces(), occupancy.getFreeSpaces());
        } else {
            domainOccupancy.setFreeSpaces(occupancy.getFreeSpaces());
        }
        occupancyRepository.save(domainOccupancy);
                
        template.convertAndSend("/topic/occupancy", occupancy);
        return new Response();
    }

}
