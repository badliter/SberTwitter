package ru.sbt.twitter.comments;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.lang.NonNull;

@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {
    @Value("${cassandra.keyspace}")
    private String keyspace;

    @Override @NonNull
    protected String getKeyspaceName() {
        return keyspace;
    }

    @Override
    protected boolean getMetricsEnabled() { return false; }
}
