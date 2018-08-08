/**
 * 
 */
package com.faac.occupancy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.faac.occupancy.domain.Occupancy;

/**
 * @author nneikov
 *
 */
public interface OccupancyRepository extends CrudRepository<Occupancy, Long> {
    
    Occupancy findByParkingId(String parkingId);
    
    List<Occupancy> findByCompanyName(String companyName);
    
    @Query("from Occupancy where companyName = :companyName")
    Occupancy fooQuery(@Param("companyName") String copanyName);
    
    @Query(value="SELECT * FROM occupancy WHERE company_name = :companyName", nativeQuery=true)
    Occupancy plainSql(@Param("companyName") String copanyName);

}
