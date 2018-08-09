/**
 * 
 */
package com.faac.occupancy.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.faac.occupancy.domain.Occupancy;

/**
 * @author nneikov
 *
 */
public interface OccupancyRepository extends CrudRepository<Occupancy, Long> {
    
    Occupancy findByParkingId(String parkingId);
    
    List<Occupancy> findByCompanyId(long companyId);

}
