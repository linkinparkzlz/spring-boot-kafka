package com.example.springbootkafka.serializer;

import com.example.springbootkafka.domain.User;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Map;

public class ObjectSerializer implements Serializer<Object> {

    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public byte[] serialize(String s, Object user) {

        System.out.println("topic: " + s);

        byte[] dataArray = null;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(user);

            dataArray = outputStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return dataArray;
    }

    @Override
    public void close() {

    }
}













