package com.eduardoguedes.trackhours.menagerHours;

import com.eduardoguedes.trackhours.menagerHours.dto.EmployeeMenageDTO;
import com.eduardoguedes.trackhours.menagerHours.dto.MenageHoursMainDTO;
import com.eduardoguedes.trackhours.menagerHours.dto.TimeEntryMenageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenageHoursService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EmployeeMenageDTO> getTimeEntryReport() {
        String sql = "WITH cte_marcacoes AS ( " +
                "   SELECT " +
                "       time_entry.epl_id, " +
                "       epl_name, " +
                "       tme_date, " +
                "       tme_time AS marcacao, " +
                "       ROW_NUMBER() OVER (PARTITION BY time_entry.epl_id, epl_name, tme_date ORDER BY tme_time) AS marcacao_num " +
                "   FROM " +
                "       public.time_entry " +
                "   JOIN employee on (time_entry.epl_id = employee.epl_id) " +
                ") " +
                "SELECT " +
                "   epl_id, " +
                "   epl_name, " +
                "   tme_date, " +
                "   MAX(CASE WHEN marcacao_num = 1 THEN marcacao END) AS timeEntry1, " +
                "   MAX(CASE WHEN marcacao_num = 2 THEN marcacao END) AS timeEntry2, " +
                "   MAX(CASE WHEN marcacao_num = 3 THEN marcacao END) AS timeEntry3, " +
                "   MAX(CASE WHEN marcacao_num = 4 THEN marcacao END) AS timeEntry4, " +
                "   TO_CHAR( " +
                "       (INTERVAL '1 second' * " +
                "           (COALESCE(EXTRACT(EPOCH FROM (MAX(CASE WHEN marcacao_num = 2 THEN marcacao END) - MAX(CASE WHEN marcacao_num = 1 THEN marcacao END))), 0) + " +
                "           COALESCE(EXTRACT(EPOCH FROM (MAX(CASE WHEN marcacao_num = 4 THEN marcacao END) - MAX(CASE WHEN marcacao_num = 3 THEN marcacao END))), 0) " +
                "       )), " +
                "       'HH24:MI' " +
                "   ) AS totalHours " +
                "FROM " +
                "   cte_marcacoes " +
                " GROUP BY " +
                "   cte_marcacoes.epl_id, epl_name, tme_date " +
                "ORDER BY " +
                "   cte_marcacoes.epl_name, tme_date;";

        List<MenageHoursMainDTO> timeEntries = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MenageHoursMainDTO.class));

        List<EmployeeMenageDTO> employeeMenageDTOList = new ArrayList<>();
        Map<Integer, EmployeeMenageDTO> employeeMap = new HashMap<>();

        for (MenageHoursMainDTO menageHoursMainDTO : timeEntries) {
            int eplId = menageHoursMainDTO.getEplId();
            String eplName = menageHoursMainDTO.getEplName();
            String tmeDate = menageHoursMainDTO.getTmeDate();
            String timeEntry1 = menageHoursMainDTO.getTimeEntry1();
            String timeEntry2 = menageHoursMainDTO.getTimeEntry2();
            String timeEntry3 = menageHoursMainDTO.getTimeEntry3();
            String timeEntry4 = menageHoursMainDTO.getTimeEntry4();
            String totalHours = menageHoursMainDTO.getTotalHours();

            // Se o Employee ainda não foi adicionado ao mapa, criamos uma nova entrada
            if (!employeeMap.containsKey(eplId)) {
                employeeMap.put(eplId, new EmployeeMenageDTO(eplId, eplName, new ArrayList<>()));
            }

            // Adiciona as marcações do funcionário no objeto EmployeeMenageDTO correspondente
            EmployeeMenageDTO employeeDTO = employeeMap.get(eplId);
            employeeDTO.getTmeEntryRecords().add(new TimeEntryMenageDTO(tmeDate, timeEntry1, timeEntry2, timeEntry3, timeEntry4, totalHours));
        }

        employeeMenageDTOList.addAll(employeeMap.values());

        return employeeMenageDTOList;
    }

    public EmployeeMenageDTO getTimeEntryReport(int elpId) {
        String sql = "WITH cte_marcacoes AS ( " +
                "   SELECT " +
                "       time_entry.epl_id, " +
                "       epl_name, " +
                "       tme_date, " +
                "       tme_time AS marcacao, " +
                "       ROW_NUMBER() OVER (PARTITION BY time_entry.epl_id, epl_name, tme_date ORDER BY tme_time) AS marcacao_num " +
                "   FROM " +
                "       public.time_entry " +
                "   JOIN employee on (time_entry.epl_id = employee.epl_id) " +
                ") " +
                "SELECT " +
                "   epl_id, " +
                "   epl_name, " +
                "   tme_date, " +
                "   MAX(CASE WHEN marcacao_num = 1 THEN marcacao END) AS timeEntry1, " +
                "   MAX(CASE WHEN marcacao_num = 2 THEN marcacao END) AS timeEntry2, " +
                "   MAX(CASE WHEN marcacao_num = 3 THEN marcacao END) AS timeEntry3, " +
                "   MAX(CASE WHEN marcacao_num = 4 THEN marcacao END) AS timeEntry4, " +
                "   TO_CHAR( " +
                "       (INTERVAL '1 second' * " +
                "           (COALESCE(EXTRACT(EPOCH FROM (MAX(CASE WHEN marcacao_num = 2 THEN marcacao END) - MAX(CASE WHEN marcacao_num = 1 THEN marcacao END))), 0) + " +
                "           COALESCE(EXTRACT(EPOCH FROM (MAX(CASE WHEN marcacao_num = 4 THEN marcacao END) - MAX(CASE WHEN marcacao_num = 3 THEN marcacao END))), 0) " +
                "       )), " +
                "       'HH24:MI' " +
                "   ) AS totalHours " +
                "FROM " +
                "   cte_marcacoes " +
                " where cte_marcacoes.epl_id =  " + elpId +
                " GROUP BY " +
                "   cte_marcacoes.epl_id, epl_name, tme_date " +
                " ORDER BY " +
                "   cte_marcacoes.epl_name, tme_date " +
                " limit 1";

        List<MenageHoursMainDTO> timeEntries = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MenageHoursMainDTO.class));

        Map<Integer, EmployeeMenageDTO> employeeMap = new HashMap<>();

        EmployeeMenageDTO itemEmployDTORet = new EmployeeMenageDTO();
        for (MenageHoursMainDTO menageHoursMainDTO : timeEntries) {
            int eplId = menageHoursMainDTO.getEplId();
            String eplName = menageHoursMainDTO.getEplName();
            String tmeDate = menageHoursMainDTO.getTmeDate();
            String timeEntry1 = menageHoursMainDTO.getTimeEntry1();
            String timeEntry2 = menageHoursMainDTO.getTimeEntry2();
            String timeEntry3 = menageHoursMainDTO.getTimeEntry3();
            String timeEntry4 = menageHoursMainDTO.getTimeEntry4();
            String totalHours = menageHoursMainDTO.getTotalHours();

            if (!employeeMap.containsKey(eplId)) {
                employeeMap.put(eplId, new EmployeeMenageDTO(eplId, eplName, new ArrayList<>()));
            }


            EmployeeMenageDTO employeeDTO = employeeMap.get(eplId);
            employeeDTO.getTmeEntryRecords().add(new TimeEntryMenageDTO(tmeDate, timeEntry1, timeEntry2, timeEntry3, timeEntry4, totalHours));
            itemEmployDTORet = employeeDTO;
        }



        return itemEmployDTORet;
    }



}
