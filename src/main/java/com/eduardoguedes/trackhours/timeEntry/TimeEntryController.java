package com.eduardoguedes.trackhours.timeEntry;

import com.eduardoguedes.trackhours.employee.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entry")
public class TimeEntryController {

    @Autowired
    private TimeEntryService timeEntryService;

    @PostMapping
    private void registerNewTimeEntry(@RequestBody TimeEntryEntity timeEntryEntity) {
        timeEntryService.registerNewTimeEntry(timeEntryEntity);
    }

    @GetMapping
    public List<TimeEntryEntity> listAllTimeEntry() {
        return timeEntryService.getAllTimeEntry();
    }
}
