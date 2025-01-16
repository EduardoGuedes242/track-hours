package com.eduardoguedes.trackhours.menagerHours;

import com.eduardoguedes.trackhours.menagerHours.dto.MenageHoursMainDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenageHoursService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<MenageHoursMainDTO> getTimeEntryReport() {
        String sql = "WITH cte_marcacoes AS ( " +
                "   SELECT " +
                "       epl_id, " +
                "       tme_date, " +
                "       tme_time AS marcacao, " +
                "       ROW_NUMBER() OVER (PARTITION BY epl_id, tme_date ORDER BY tme_time) AS marcacao_num " +
                "   FROM " +
                "       public.time_entry " +
                ") " +
                "SELECT " +
                "   epl_id, " +
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
                "GROUP BY " +
                "   epl_id, tme_date " +
                "ORDER BY " +
                "   epl_id, tme_date;";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MenageHoursMainDTO.class));
    }

}
