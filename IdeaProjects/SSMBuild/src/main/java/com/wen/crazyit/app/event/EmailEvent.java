package com.wen.crazyit;

import org.springframework.context.ApplicationEvent;

/**
 * @author ：peter
 * @description：TODO
 * @date ：2021/1/18 8:43
 */
public class EmailEvent extends ApplicationEvent {
    private String address;
    private String text;
    public EmailEvent(Object source){
        super(source);
    }
    public EmailEvent(Object source,String address,String text)
    {
        super(source);
        this.address = address;
        this.text = text;
    }

}
