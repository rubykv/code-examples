package com.example.hosp_ai_demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mylib")
public class HospAIConfig {
    private Database db = new Database();
    private Logging logging = new Logging();
    private Features features = new Features();

    // Getters and setters for nested classes
    public static class Database {
        private String url;
        private String username;
        private String password;
        private int maxConnections;

        // Getters and setters
        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
        // ... other getters and setters
    }

    public static class Logging {
        private String level;
        private String path;

        // Getters and setters
        public String getLevel() { return level; }
        public void setLevel(String level) { this.level = level; }
    }

    public static class Features {
        private boolean advancedCaching;
        private boolean monitoringEnabled;

        // Getters and setters
        public boolean isAdvancedCaching() { return advancedCaching; }
        public void setAdvancedCaching(boolean advancedCaching) { this.advancedCaching = advancedCaching; }
    }

    // Getters for nested classes
    public Database getDb() { return db; }
    public Logging getLogging() { return logging; }
    public Features getFeatures() { return features; }
}
