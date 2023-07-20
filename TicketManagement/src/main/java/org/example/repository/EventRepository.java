package org.example.repository;

import org.example.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {
    List<Event> getAllByVenueVenueIDAndEventTypeEventTypeName(Integer venueID,String eventTypeName);
}
