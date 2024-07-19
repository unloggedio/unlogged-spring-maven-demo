package org.unlogged.demo.models.session;

import lombok.Data;

import java.util.List;

@Data
public class Departments {
    private List<DepartmentDTO> departments;
}
