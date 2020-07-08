package com.mockorg.demo.daos;

import com.mockorg.demo.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Event, Long> {

}
