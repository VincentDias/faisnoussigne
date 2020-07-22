
package com.LSF.faisnoussigne.webservices.googleGeocode.models;

import java.util.HashMap;
import java.util.Map;

public class Geometry {

    private Location location;
    private String locationType;
    private Viewport viewport;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
