package com.paloma.testeapiemprestimo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class InstallmentDTO {

    private Integer number;
    private Double price;
    private Date date;

    public InstallmentDTO(Integer number, Double price, Date date) {
        this.number = number;
        this.price = price;
        this.date = date;
    }

}
