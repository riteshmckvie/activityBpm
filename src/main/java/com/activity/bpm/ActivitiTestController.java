package com.activity.bpm;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivitiTestController {

	@Autowired
	private RuntimeService runtimeService;

	@Value("${spring.datasource.password}")
	private String passwd;

	@Value("${spring.datasource.url}")
	private String jdbcUrl;

	@Value("${spring.datasource.username}")
	private String jdbcUserName;

	@RequestMapping(value = "/start-test-process", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void startTestProcess() {
		runtimeService.startProcessInstanceByKey("emp");
		System.out.println("started now " + runtimeService.createProcessInstanceQuery().count());
		//
		// ProcessEngineConfiguration config =
		// (StandaloneProcessEngineConfiguration)ProcessEngineConfiguration
		// .createStandaloneProcessEngineConfiguration();
		// config.setJdbcDriver("com.mysql.jdbc.Driver");
		// config.setJdbcPassword(passwd);
		// config.setJdbcUrl(jdbcUrl);
		// config.setJdbcUsername(jdbcUserName);
		// //config.setDatabaseType();
		// config.setDatabaseSchemaUpdate("true");
		// ProcessEngine processEngine = config.buildProcessEngine();
		ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
				.buildProcessEngine();
		// RepositoryService repositoryService =
		// processEngine.getRepositoryService();
		// repositoryService.createDeployment().addClasspathResource("/activityBpm/src/main/resources/processes/TestProcess.bpmn20.xml").deploy();
		// RuntimeService runtimeService2 = processEngine.getRuntimeService();
	}

}
