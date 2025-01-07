package com.hotel.managment.system.models;

// Applying chain of responsibility pattern
public interface Amenities {

    public void setNextChain(Amenities nextAmenity);

    public void levyCharge(String amenityName);
}
