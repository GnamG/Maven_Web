package com.fc.config;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.Properties;

public class CustomEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        // 自定义的配置文件
        String[] profiles = {"jdbc.properties,student.yml"};

        // 获取全部文件
        for (String profile : profiles) {
           // 把配置文件转为Resource  多态
            Resource resource = new ClassPathResource(profile);

            Properties properties;
            // 如果配置未见是Properties文件
            if (profile.contains("properties")) {
                properties = new Properties();

                try {
                    properties.load(resource.getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
               }

                // 否则就是yml文件
            } else {
                YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
                factoryBean.setResources(resource);
                properties = factoryBean.getObject();
            }
            PropertiesPropertySource source = new PropertiesPropertySource(profile, properties);

            environment.getPropertySources().addLast(source);
        }
    }
}
