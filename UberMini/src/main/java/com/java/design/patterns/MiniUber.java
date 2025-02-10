package com.java.design.patterns;

public interface MiniUber {
    Trip report( int driverId, int lat, int lng);
    Trip request( int riderId, int lat, int lng);
}
