package com.eduardoguedes.trackhours.timeEntry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeEntryRepository extends JpaRepository<TimeEntryEntity, Integer> {
}
