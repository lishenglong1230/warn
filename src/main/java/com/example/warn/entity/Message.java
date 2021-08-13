package com.example.warn.entity;

import org.springframework.stereotype.Component;

@Component
/*@Data
@NoArgsConstructor*/
public class Message {
    /*private int id;
    private String name;
    private String carNumber;
    private String railway;
    private String type;
    private String date;

    *//*public Message(String name, String carNumber, String railway, String type, String date) {
        this.name = name;
        this.carNumber = carNumber;
        this.railway = railway;
        this.type = type;
        this.date = date;
    }*/

    private String address;
    private String type;
    private String msg;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
