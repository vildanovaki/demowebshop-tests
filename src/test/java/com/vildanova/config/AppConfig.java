package com.vildanova.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/app.properties"})

public interface AppConfig extends Config{

    String login();
    String password();
}
