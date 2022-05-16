package com.paloma.testeapiemprestimo.model;


import com.paloma.testeapiemprestimo.model.vo.InstallmentVO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@Data
@Document(collection = "loan")
public class Loan{

    @Id
    private String id;

    private Double value;
    private Date firstInstallment;
    private Integer qtdInstallments;

    private List<InstallmentVO> installmentsVO = new ArrayList<>();

}
