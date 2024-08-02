package com.geekymon2.carmarketplace.core.common;

import com.geekymon2.carmarketplace.core.models.StatusDto;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class ApiStatus {
    public StatusDto getStatus() {
        String hostname = "";
        String environment = "";
        String version = "0.0.0";
        final String UNKNOWN_LABEL = "unknown";

        try {
            hostname = java.net.InetAddress.getLocalHost().getHostName();
            environment = System.getenv("ENVIRONMENT");
            Path versionFilePath = Paths.get("./version.properties");
            version = Files.readString(versionFilePath).split("=")[1];
        }
        catch (UnknownHostException uhx) {
            hostname = UNKNOWN_LABEL;
            log.error(String.format("Error getting hostname: %s", uhx));
        }
        catch (IOException iox) {
            version = UNKNOWN_LABEL;
            log.error(String.format("Error getting version: %s", iox));
        }

        return new StatusDto(environment, version, hostname, "This is the status endpoint");
    }
}
