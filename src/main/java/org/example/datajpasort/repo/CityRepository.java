package org.example.datajpasort.repo;

import org.example.datajpasort.model.City;
import org.example.datajpasort.model.FullAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends JpaRepository<City, Long> {

    @Query("select new org.example.datajpasort.model.FullAddress(c.name, a.street) "
            + "from City c LEFT JOIN Address a "
            + "on c.id = a.cityId "
            + "where c.name = :name")
    Page<FullAddress> getFullAddresses(@Param("name") String cityName, Pageable pageable);
}
