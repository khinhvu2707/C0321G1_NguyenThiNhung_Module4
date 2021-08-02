package com.example.dto;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="educationDegree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int educationDegreeId;
    private String educationDegreeName;

    @OneToMany(mappedBy = "educationDegree",cascade = CascadeType.ALL)
    private Set<Employee> employeeSet;

    public EducationDegree(int educationDegreeId, String educationDegreeName) {
        this.educationDegreeId = educationDegreeId;
        this.educationDegreeName = educationDegreeName;
    }

    public EducationDegree() {
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }
}
