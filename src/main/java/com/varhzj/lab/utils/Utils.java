package com.varhzj.lab.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Utils {

    public Properties loadProperties(Class<?> clazz, String path) throws IOException {
        Properties props = new Properties();
        // 中文乱码处理
        props.load(new InputStreamReader(clazz.getResourceAsStream(path), StandardCharsets.UTF_8));
        return props;
    }

}
