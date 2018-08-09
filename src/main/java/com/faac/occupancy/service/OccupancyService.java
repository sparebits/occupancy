package com.faac.occupancy.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faac.occupancy.dao.CompanyRepository;
import com.faac.occupancy.dao.OccupancyRepository;
import com.faac.occupancy.domain.Company;
import com.faac.occupancy.model.Occupancy;
import com.faac.occupancy.model.Response;
import com.faac.occupancy.model.ResponseType;

@RestController
public class OccupancyService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private SimpMessagingTemplate template;
    
    @Autowired
    private OccupancyRepository occupancyRepository;
    
    @Autowired
    private CompanyRepository companyRepository;

    @RequestMapping(value = "/occupancy", method = RequestMethod.PUT)
    public Response pushOccupancy(@RequestBody Occupancy occupancy) {
        logger.info("pushing occupancy...");
        
        Company domainCompany = companyRepository.findByName(occupancy.getCompanyName());
        if (domainCompany == null) {
            domainCompany = companyRepository.save(new Company(occupancy.getCompanyName()));
        }
        
        com.faac.occupancy.domain.Occupancy domainOccupancy = occupancyRepository.findByParkingId(occupancy.getParkingId());
        
        if (domainOccupancy == null) {
            domainOccupancy = new com.faac.occupancy.domain.Occupancy(occupancy.getParkingId(), occupancy.getTotalPlaces(), occupancy.getFreeSpaces(), domainCompany.getId());
        } else {
            domainOccupancy.setFreeSpaces(occupancy.getFreeSpaces());
        }
        occupancyRepository.save(domainOccupancy);
                
        template.convertAndSend("/topic/occupancy", occupancy);
        return new Response();
    }
    
    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public Response getCompanies() {
        List<Company> companies = (List<Company>)companyRepository.findAll();
        return new Response(companies, ResponseType.ok);
    }
    
    @RequestMapping(value = "/occupancies", method = RequestMethod.GET)
    public Response getOccupancies(@RequestParam("companyId") long companyId) {
        List<com.faac.occupancy.domain.Occupancy> occupancies = (List<com.faac.occupancy.domain.Occupancy>)occupancyRepository.findByCompanyId(companyId);
        return new Response(occupancies, ResponseType.ok);
    }

}
