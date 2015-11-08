package com.example.junhaochiew.newbostonsql;

/**
 * Created by junhaochiew on 7/11/2015.
 */
public class Route {

    private int _id;
    private String _Route;
    private String _location1Name;
    private String _location2Name;
    private String _locationXCoordinates;
    private String _locationYCoordinates;
    private Integer _walkTime;
    private Integer _busTime;
    private Integer _taxiTime;
    private Float _busCost;
    private Float _taxiCost;
    private String _locationDescription;

    public Route() {
    }

    public Route(String _location1Name, String _location2Name, String _locationXCoordinates, String _locationYCoordinates,
                 Integer _walkTime, Integer _busTime, Integer _taxiTime, Float _busCost, Float _taxiCost, String _locationDescription) {
        this._Route=  _location1Name + " to " + _location2Name;
        this._location1Name = _location1Name;
        this._location2Name = _location2Name;
        this._Route = _location1Name + " to " + _location2Name;
        this._locationDescription = _locationDescription;
        this._locationXCoordinates = _locationXCoordinates;
        this._locationYCoordinates = _locationYCoordinates;
        this._walkTime=_walkTime;
        this._busCost=_busCost;
        this._busTime=_busTime;
        this._taxiCost=_taxiCost;
        this._taxiTime=_taxiTime;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_location1Name(String _location1Name) {
        this._location1Name = _location1Name;
    }

    public void set_locationXCoordinates(String _locationXCoordinates) {
        this._locationXCoordinates = _locationXCoordinates;
    }

    public void set_locationYCoordinates(String _locationYCoordinates) {
        this._locationYCoordinates = _locationYCoordinates;
    }

    public void set_location2Name(String _location2Name) {
        this._location2Name = _location2Name;
    }

    public void set_locationDescription(String _locationDescription) {
        this._locationDescription = _locationDescription;
    }

    public String get_Route() {
        return _Route;
    }

    public String get_location2Name() {
        return _location2Name;
    }

    public String get_locationYCoordinates() {
        return _locationYCoordinates;
    }

    public int get_id() {
        return _id;
    }

    public String get_location1Name() {
        return _location1Name;
    }

    public String get_locationXCoordinates() {
        return _locationXCoordinates;
    }

    public String get_locationDescription() {
        return _locationDescription;
    }

    public Integer get_walkTime() {
        return _walkTime;
    }

    public Integer get_busTime() {
        return _busTime;
    }

    public Integer get_taxiTime() {
        return _taxiTime;
    }

    public Float get_busCost() {
        return _busCost;
    }

    public Float get_taxiCost() {
        return _taxiCost;
    }
}
