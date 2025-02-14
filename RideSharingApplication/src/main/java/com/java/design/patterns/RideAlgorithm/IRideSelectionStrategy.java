package com.java.design.patterns.RideAlgorithm;


import com.java.design.patterns.model.Ride;

public interface IRideSelectionStrategy {
    Ride getRide(String src,String dest,int seats,String params);
}
