package io.ribot.app.data.model;

import java.util.Date;

public class CheckIn {
    public String id;
    public Venue venue;
    //Location name. Only to be used if not attached to a specific venue.
    public String label;
    public Date checkedInDate;

    public boolean hasVenue() {
        return venue != null && venue.label != null;
    }

    public String getLocationName() {
        if (hasVenue()) {
            return venue.label;
        }
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckIn checkIn = (CheckIn) o;

        if (id != null ? !id.equals(checkIn.id) : checkIn.id != null) return false;
        if (venue != null ? !venue.equals(checkIn.venue) : checkIn.venue != null) return false;
        return !(label != null ? !label.equals(checkIn.label) : checkIn.label != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (venue != null ? venue.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        return result;
    }
}