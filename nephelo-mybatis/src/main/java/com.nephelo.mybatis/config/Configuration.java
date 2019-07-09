package com.nephelo.mybatis.config;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Configuration {
    private Connection connection;
    private Map<String, String> mappers = new HashMap<>();
}
