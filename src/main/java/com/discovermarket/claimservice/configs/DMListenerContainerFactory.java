package com.discovermarket.claimservice.configs;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.jms.BytesMessage;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Component;

@Component
public class DMListenerContainerFactory {
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerFactory(ConnectionFactory connectionFactory,
                                                                      DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setSessionTransacted(false);
        return factory;
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter() {
            protected Object convertFromBytesMessage(BytesMessage message, JavaType targetJavaType)
                    throws JMSException, IOException {

                String encoding = DEFAULT_ENCODING;
                byte[] bytes = new byte[(int) message.getBodyLength()];
                message.readBytes(bytes);
                try {
                    String body = new String(bytes, encoding);
                    return new ObjectMapper().readValue(body, targetJavaType);
                } catch (UnsupportedEncodingException ex) {
                    throw new MessageConversionException("Cannot convert bytes to String", ex);
                }
            }
        };
        converter.setTargetType(MessageType.BYTES);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
