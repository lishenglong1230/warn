package com.example.warn.entity;

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
}
