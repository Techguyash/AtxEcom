package com.atx.atxecom.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author ashiq
 * @createdOn 09/03/25 2:58 pm
 * @project AtxEcom
 **/
@Component
public class H2BackupConfig
{
    private final JdbcTemplate jdbcTemplate;
    private final String dbUrl;

    @Autowired
    public H2BackupConfig(JdbcTemplate jdbcTemplate, @Value("${spring.datasource.url}") String dbUrl) {
        this.jdbcTemplate = jdbcTemplate;
        this.dbUrl = dbUrl; // Now Spring can inject this properly
    }

    @EventListener(ContextClosedEvent.class)
    public void backupDatabase() {
        try {
            String backupFile = "./data/backup.sql";
            jdbcTemplate.execute("SCRIPT TO '" + backupFile + "'");
            System.out.println("Database backup saved to: " + backupFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    public ApplicationRunner initializeDatabase() {
        return args -> {
            File backupFile = new File("./data/backup.sql");

            // Check if ANY table exists in the database
            Integer tableCount = jdbcTemplate.queryForObject(
                    "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='PUBLIC'", Integer.class);

            if (tableCount != null && tableCount > 0) {
                System.out.println("Database already has tables. Skipping import.");
                return;
            }

            if (backupFile.exists()) {
                System.out.println("Restoring database from backup.sql...");
                jdbcTemplate.execute("RUNSCRIPT FROM '" + backupFile.getAbsolutePath() + "'");
                System.out.println("Database restoration complete.");
            } else {
                System.out.println("No backup file found. Skipping database restoration.");
            }
        };
    }
}
