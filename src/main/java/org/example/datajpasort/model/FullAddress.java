package org.example.datajpasort.model;

import java.util.Objects;
import java.util.StringJoiner;

public class FullAddress {
    private String city;
    private String street;

    public FullAddress(final String city, final String street) {
        this.city = city;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FullAddress.class.getSimpleName() + "[", "]")
                .add("city='" + city + "'")
                .add("street='" + street + "'")
                .toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final FullAddress that = (FullAddress) o;
        return Objects.equals(city, that.city) &&
                Objects.equals(street, that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street);
    }
}
