package com.vaibhav;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class User_Deserializer<T> implements Deserializer<T> {
    private ObjectMapper objectMapper = new ObjectMapper();
    private Class<T> className;
    public static final String KEY_CLASS_NAME_CONFIG="key.class.name";
    public static final String VALUE_CLASS_NAME_CONFIG="value.class.name";
    public User_Deserializer(){}
    public void configure(Map<String,?> props, boolean isKey){
        if(isKey)
            className=(Class<T>) props.get(KEY_CLASS_NAME_CONFIG);
        else
            className=(Class<T>) props.get(VALUE_CLASS_NAME_CONFIG);
    }
    @Override
    public T deserialize(String topic, byte[] data) {
        if(data==null){
            return null;
        }
        try{
            return objectMapper.readValue(data,className);
        }catch(Exception e) {
            throw new SerializationException(e);
        }
    }
    public void close(){}
}
