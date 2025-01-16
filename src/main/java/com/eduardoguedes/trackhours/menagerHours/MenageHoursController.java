package com.eduardoguedes.trackhours.menagerHours;

import com.eduardoguedes.trackhours.menagerHours.dto.MenageHoursMainDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manege-hours")
public class MenageHoursController {

    @Autowired
    private MenageHoursService menageHoursService;

    @GetMapping
    public List<MenageHoursMainDTO> menageHoursMainList() {
        return menageHoursService.getTimeEntryReport();
    }
}
