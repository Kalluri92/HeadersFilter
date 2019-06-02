package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@XmlRootElement
public class CommonFeilds {
    private String header1;
    private String header2;
    private String header3;

    public CommonFeilds(HttpHeaders headers) {
        this.header1 = headers.get("header1").get(0);
        this.header2 = headers.get("header2").get(0);
        this.header3 = headers.get("header3").get(0);
    }
}
