/**
 * 
 */
package com.faac.occupancy.dao;

import org.springframework.data.repository.CrudRepository;

import com.faac.occupancy.domain.Company;

/**
 * @author nneikov
 *
 */
public interface CompanyRepository extends CrudRepository<Company, Long>  {
    
    Company findByName(String name);

}
