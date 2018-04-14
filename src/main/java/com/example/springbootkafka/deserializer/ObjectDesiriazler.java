package com.example.springbootkafka.deserializer;

import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

public class ObjectDesiriazler implements Deserializer<Object> {

    @Override
    public void configure(Map map, boolean b) {


    }

    @Override
    public Object deserialize(String s, byte[] bytes) {

        Object object = null;

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

        try {
            ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);

            try {
                object = inputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("topic: " + s);

        return object;


    }

    @Override
    public void close() {

    }
}
