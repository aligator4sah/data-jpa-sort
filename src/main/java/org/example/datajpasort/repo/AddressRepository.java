package org.example.datajpasort.repo;

import org.example.datajpasort.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
