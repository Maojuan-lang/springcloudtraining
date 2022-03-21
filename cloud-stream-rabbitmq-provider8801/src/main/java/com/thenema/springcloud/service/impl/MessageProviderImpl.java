package com.thenema.springcloud.service.impl;

import com.thenema.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author xiaoxiang
 * @data 2022/3/14 20:54
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    @Output(Source.OUTPUT)
    private MessageChannel messageChannel;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        messageChannel.send(MessageBuilder.withPayload(serial).build());
        System.out.println("****serial："+serial);
        return null;
    }
}
