package com.demo.spring.consumer.amqp;

public interface AmqpConsumer<T> {

    void consumer(T t);

}
