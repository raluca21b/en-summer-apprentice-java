package org.example.repository;

import org.example.model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Integer> {
}
