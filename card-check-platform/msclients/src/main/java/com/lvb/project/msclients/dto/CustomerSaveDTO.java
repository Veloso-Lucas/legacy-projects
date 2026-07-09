package com.lvb.project.msclients.dto;

import com.lvb.project.msclients.entity.Customer;
import lombok.Data;

@Data
public class CustomerSaveDTO {

    private String cpf;
    private String name;
    private Integer age;

    public Customer toModel() {
        return new Customer(cpf, name, age);
    }
}
