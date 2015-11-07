package com.example.junhaochiew.newbostonsql;

/**
 * Created by junhaochiew on 7/11/2015.
 */
public class Locations {

    private int _id;
    private String _locationName;
    private String _locationCoordinates;
    private String _locationDescription;

    public Locations() {
    }

    public Locations(String _locationName, String _locationCoordinates, String _locationDescription) {
        this._locationName=_locationName;
        this._locationDescription=_locationDescription;
        this._locationCoordinates=_locationCoordinates;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_locationName(String _locationName) {
        this._locationName = _locationName;
    }

    public void set_locationCoordinates(String _locationCoordinates) {
        this._locationCoordinates = _locationCoordinates;
    }

    public void set_locationDescription(String _locationDescription) {
        this._locationDescription = _locationDescription;
    }

    public int get_id() {
        return _id;
    }

    public String get_locationName() {
        return _locationName;
    }

    public String get_locationCoordinates() {
        return _locationCoordinates;
    }

    public String get_locationDescription() {
        return _locationDescription;
    }
}
