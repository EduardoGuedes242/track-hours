package com.eduardoguedes.trackhours.menagerHours;

import com.eduardoguedes.trackhours.menagerHours.dto.EmployeeMenageDTO;
import com.eduardoguedes.trackhours.menagerHours.dto.MenageHoursMainDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manege-hours")
public class MenageHoursController {

    @Autowired
    private MenageHoursService menageHoursService;

    @GetMapping
    public List<EmployeeMenageDTO> menageHoursMainList() {
        return menageHoursService.getTimeEntryReport();
    }

    @GetMapping("/{eplId}")
    public EmployeeMenageDTO menageHoursMainListForEmployee(@PathVariable int eplId) {
        return menageHoursService.getTimeEntryReport(eplId);
    }
}
