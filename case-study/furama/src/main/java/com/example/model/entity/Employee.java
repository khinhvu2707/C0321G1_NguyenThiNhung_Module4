package com.example.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String employeeName;
    @Column(columnDefinition = "DATE")
    private String employeeBirthday;
    private int employeeIdCard;
    private double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    @JsonManagedReference
    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "position_id",referencedColumnName = "positionId")
    private Position position;
    @JsonManagedReference
    @ManyToOne(targetEntity = EducationDegree.class)
    @JoinColumn(name = "education_degree_id",referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegree;
    @JsonManagedReference
    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "division_id",referencedColumnName = "divisionId")
    private Division division;
    private String username;

    @JsonBackReference
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Contract> contractSet;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String employeeBirthday, int employeeIdCard, double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Position position, EducationDegree educationDegree, Division division, String username, Set<Contract> contractSet) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.username = username;
        this.contractSet = contractSet;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public int getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(int employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
