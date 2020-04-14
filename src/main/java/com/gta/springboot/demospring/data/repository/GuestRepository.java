package com.gta.springboot.demospring.data.repository;

import com.gta.springboot.demospring.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Long> {

}
