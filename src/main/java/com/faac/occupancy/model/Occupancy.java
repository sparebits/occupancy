/**
 * 
 */
package com.faac.occupancy.model;

/**
 * @author nneikov
 *
 */
public class Occupancy {

    private String parkingId;
    private int totalPlaces;
    private int freeSpaces;
    private String companyName;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
