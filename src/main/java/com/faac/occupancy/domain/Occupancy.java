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

    public Occupancy() {
    }

    public Occupancy(String parkingId, int totalPlaces, int freeSpaces) {
        this.parkingId = parkingId;
        this.totalPlaces = totalPlaces;
        this.freeSpaces = freeSpaces;
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

}
