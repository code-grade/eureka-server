package com.codegrade.eurekaserver;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;
import com.netflix.eureka.EurekaServerContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class InfoController {



    @GetMapping(path = "/info")
    public Map<String, Object> welcome() {
        var applications = EurekaServerContextHolder.getInstance()
                .getServerContext().getRegistry()
                .getApplications();

        return applications.getRegisteredApplications().stream()
                .collect(Collectors.toMap(
                        Application::getName,
                        app -> app.getInstances().stream()
                                .map(InstanceInfo::getInstanceId).collect(Collectors.toList())
                ));
    }
}
