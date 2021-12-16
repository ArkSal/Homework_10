package models.configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EnvironmentConfig {
    private String ulr;
    private String browser;
    private String wait;
    private String firstName;
    private String lastName;
    private String flag;

    public String getUlr() {
        return ulr;
    }

    public String getBrowser() {
        return browser;
    }

    public String getWait() {
        return wait;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFlag() {
        return flag;
    }
}