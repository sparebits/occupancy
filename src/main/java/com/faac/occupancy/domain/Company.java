/**
 * 
 */
package com.faac.occupancy.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author nneikov
 *
 */
@Entity
public class Company {
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    private long id;
    private String name;
    
    public Company() {}
    
    public Company(String name) {
        this.name = name;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
}
