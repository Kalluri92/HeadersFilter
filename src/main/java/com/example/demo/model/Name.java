package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@XmlRootElement
public class Name extends CommonFeilds {

    private String name;

    public Name(HttpHeaders headers){
        super(headers);
        this.name = "Iam Krishna";
    }

}
