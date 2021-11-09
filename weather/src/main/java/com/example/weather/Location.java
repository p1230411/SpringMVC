package com.example.weather;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private String name;
    private String busno;

    public Location(){

    }
    public Location(String name, String busno){
        this.name = name;
        this.busno = busno;
    }
}
