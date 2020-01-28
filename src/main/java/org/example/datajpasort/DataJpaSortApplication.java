package org.example.datajpasort;

import org.example.datajpasort.model.Address;
import org.example.datajpasort.model.City;
import org.example.datajpasort.repo.AddressRepository;
import org.example.datajpasort.repo.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.example.datajpasort.repo")
public class DataJpaSortApplication implements CommandLineRunner {

    @Autowired
    private CityRepository cityRepo;

    @Autowired
    private AddressRepository addressRepo;

    public static void main(String[] args) {
        SpringApplication.run(DataJpaSortApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        cityRepo.save(new City(1L, "LA"));
        cityRepo.save(new City(2L, "Paris"));
        addressRepo.save(new Address(1L, 1L, "washington"));
        addressRepo.save(new Address(2L, 1L, "franklin"));
        addressRepo.save(new Address(3L, 2L, "1st ave"));
        addressRepo.save(new Address(4L, 2L, "2nd ave"));

        // Using unsafe with parenthesis works
        System.out.println(cityRepo.getFullAddresses("LA", PageRequest.of(0, 10, JpaSort.unsafe(Sort.Direction.ASC, ("(street)")))).getContent());

        // Using plain Sort leads to an Error
        System.out.println(cityRepo.getFullAddresses("LA", PageRequest.of(0, 10, Sort.by("street"))).getContent());
    }
}
