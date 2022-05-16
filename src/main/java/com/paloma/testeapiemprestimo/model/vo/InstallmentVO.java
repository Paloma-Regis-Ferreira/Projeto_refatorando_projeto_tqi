package com.paloma.testeapiemprestimo.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class InstallmentVO {

    private Integer number;
    private Double price;
    private Date date;

    public InstallmentVO(Integer number, Double price, Date date) {
        this.number = number;
        this.price = price;
        this.date = date;
    }

}
