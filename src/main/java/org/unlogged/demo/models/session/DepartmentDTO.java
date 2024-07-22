package org.unlogged.demo.models.session;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentDTO {
    private Integer departmentId;
    private String departmentName;
    private List<EmployeeDTO> employees;
    private LocationDTO location;
}
