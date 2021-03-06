package com.containersol.minimesos.config

import groovy.util.logging.Slf4j

@Slf4j
class MesosAgentConfig extends MesosContainerConfig {

    public static final String MESOS_AGENT_IMAGE = "containersol/mesos-agent"
    public static final int DEFAULT_MESOS_AGENT_PORT = 5051
    public static final String DEFAULT_MESOS_ATTRIBUTES = ""

    int portNumber = DEFAULT_MESOS_AGENT_PORT
    String attributes = DEFAULT_MESOS_ATTRIBUTES

    AgentResourcesConfig resources = new AgentResourcesConfig()

    public MesosAgentConfig(String mesosVersion) {
        imageName = MESOS_AGENT_IMAGE
        imageTag = mesosVersion + "-" + MINIMESOS_DOCKER_TAG
    }

    def resources(@DelegatesTo(AgentResourcesConfig) Closure cl) {
        delegateTo(resources, cl)
    }

}
