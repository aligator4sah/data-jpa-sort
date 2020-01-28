package org.example.datajpasort.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address {

    @Id
    private Long id;

    @Column
    private Long cityId;

    @Column
    private String street;

    public Address() {
    }

    public Address(final Long id, final Long cityId, final String street) {
        this.id = id;
        this.cityId = cityId;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(final Long cityId) {
        this.cityId = cityId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(cityId, address.cityId) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityId, street);
    }
}
