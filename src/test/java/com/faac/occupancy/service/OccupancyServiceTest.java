/**
 * 
 */
package com.faac.occupancy.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.faac.occupancy.dao.OccupancyRepository;
import com.faac.occupancy.domain.Company;
import com.faac.occupancy.model.Occupancy;
import com.faac.occupancy.model.Response;
import com.faac.occupancy.model.ResponseType;

/**
 * @author nneikov
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@Sql(scripts= {"/initial-state.sql"})
public class OccupancyServiceTest {
    
    private RestTemplate restTemplate = new RestTemplate();
    
    @Autowired
    private OccupancyRepository occupancyRepository;
    
    @Test
    public void companies() {
        Response response = restTemplate.getForEntity("http://localhost:4000/companies", Response.class).getBody();
        assertThat(response).isNotNull();
        assertThat(response.getResponseType()).isEqualTo(ResponseType.ok);
        List<Company> companies = (List<Company>)response.getItem();
        assertThat(companies.size()).isEqualTo(2);
    }
    
    @Test
    public void pushOccupancy() {
        Occupancy occupancy = new Occupancy("TEST PARK 1", 200, 50);
        occupancy.setCompanyName("Datapark");
        restTemplate.put("http://localhost:4000/occupancy", occupancy);
        
        com.faac.occupancy.domain.Occupancy domainOccupancy = occupancyRepository.findByParkingId("TEST PARK 1");
        assertThat(domainOccupancy).isNotNull();
        assertThat(domainOccupancy.getFreeSpaces()).isEqualTo(50);
    }

}
