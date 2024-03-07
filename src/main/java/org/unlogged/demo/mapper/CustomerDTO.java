package org.unlogged.demo.mapper;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

    @Id
    private Long id;
    private String name;
    private String address;
}
