package com.example.warn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Message {
    private int id;
    private String name;
    private String carNumber;
    private String railway;
    private String type;
    private String date;

    public Message(String name, String carNumber, String railway, String type, String date) {
        this.name = name;
        this.carNumber = carNumber;
        this.railway = railway;
        this.type = type;
        this.date = date;
    }
}
