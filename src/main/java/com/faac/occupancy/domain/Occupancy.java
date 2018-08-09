/**
 * 
 */
package com.faac.occupancy.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author nneikov
 *
 */
@Entity
public class Occupancy {

    @Id
    private String parkingId;
    private int totalPlaces;
    private int freeSpaces;
    
    private long companyId;

    public Occupancy() {
    }

    public Occupancy(String parkingId, int totalPlaces, int freeSpaces) {
        this.parkingId = parkingId;
        this.totalPlaces = totalPlaces;
        this.freeSpaces = freeSpaces;
    }

    public Occupancy(String parkingId, int totalPlaces, int freeSpaces, long companyId) {
        this.parkingId = parkingId;
        this.totalPlaces = totalPlaces;
        this.freeSpaces = freeSpaces;
        this.companyId = companyId;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public int getTotalPlaces() {
        return totalPlaces;
    }

    public void setTotalPlaces(int totalPlaces) {
        this.totalPlaces = totalPlaces;
    }

    public int getFreeSpaces() {
        return freeSpaces;
    }

    public void setFreeSpaces(int freeSpaces) {
        this.freeSpaces = freeSpaces;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

}
