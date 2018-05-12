package com.basant.spring.boot.cassandra.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@Configuration
@EnableReactiveCassandraRepositories
public class RactiveAppConfig extends AbstractReactiveCassandraConfiguration {

	@Value("${spring.data.cassandra.keyspace-name}")
	private String keyspaceName;

	@Override
	protected String getKeyspaceName() {
		return keyspaceName;
	}

}
