package com.miguel.distibuteddatabases.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@Configuration
@EnableJms
public class JMSConfig {

    private String activeMqUrl = "tcp://localhost:61616";

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("simple-jms-queue");
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(activeMqUrl);
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate(){ {
            return new JmsTemplate(connectionFactory());
        }
    }
}
