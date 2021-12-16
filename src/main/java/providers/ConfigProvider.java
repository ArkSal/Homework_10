package providers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import models.configuration.Configuration;
import models.configuration.EnvironmentConfig;
import models.configuration.EnvironmentName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class ConfigProvider {
    static Logger logger = LoggerFactory.getLogger(ConfigProvider.class);
    private final static String YMLConfigPath = "src/main/resources/environments.yaml";

    public static EnvironmentConfig getConfig() {
        try {
            return readConfig().getEnvironment(getEnvName());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Wrong environment value typed");
        }
        return null;
    }

    private static EnvironmentName getEnvName() {
        logger.info("Get values from : " + System.getProperty("Env_Val") + " environment");
        return EnvironmentName.valueOf(System.getProperty("Env_Val"));

    }

    private static Configuration readConfig() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        return mapper.readValue(new File(YMLConfigPath), Configuration.class);
    }
}
