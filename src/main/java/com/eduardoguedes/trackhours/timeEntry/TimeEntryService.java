package com.eduardoguedes.trackhours.timeEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeEntryService {

    @Autowired
    private TimeEntryRepository timeEntryRepository;

    public void registerNewTimeEntry(TimeEntryEntity timeEntryEntity) {
        timeEntryRepository.save(timeEntryEntity);
    }

    public List<TimeEntryEntity> getAllTimeEntry() {
       return timeEntryRepository.findAll();
    }


}
