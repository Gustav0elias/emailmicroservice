package com.example.emailmicroservice.infrastructure.config;

 
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RabbitMqConfig {

    public static final String ORDER_QUEUE_NAME = "order-queue";
    private static final String ORDER_EXCHANGE_NAME = "order-exchange";
    private static final String ORDER_ROUTING_KEY_NAME = "order.created";

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue queue() {

        return new Queue(ORDER_QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange directExchange() {

        return new DirectExchange(ORDER_EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange directExchange) {
      
        return BindingBuilder.bind(queue).to(directExchange).with(ORDER_ROUTING_KEY_NAME);
    }
}