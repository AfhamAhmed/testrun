package org.utdallas.atos.training.recommendationengine.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @Column(name = "Employee_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "Years_Experience")
    private int yearsExperience;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Email_Address")
    private String emailAddress;

    @Column(name = "Phone_Number")
    private String phoneNumber;

    @Column(name = "Current_Job_Title")
    private String currentJobTitle;

    @Column(name = "Manager_Name")
    private String managerName;

    @Column(name = "Hashed_PW")
    private String HashedPw;

    @ManyToMany
    @JoinTable(name = "employee_skills",
            joinColumns = @JoinColumn(name = "ES_Employee_ID"),
            inverseJoinColumns = @JoinColumn(name = "ES_Skill_ID"))
    private List<Skills> skills;



    @ManyToMany
    @JoinTable(name = "employee_tools",
            joinColumns = @JoinColumn(name = "ET_Employee_ID", referencedColumnName = "Employee_ID"),
            inverseJoinColumns = @JoinColumn(name = "ET_Tool_ID", referencedColumnName = "Tool_ID"))
    private List<Tools> tools;

    protected Employees() {
    }


    public Employees(String firstName, String lastName, String emailAddress, String phoneNumber, String currentJobTitle, int yearsExperience, String managerName, String HashedPw) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.currentJobTitle = currentJobTitle;
        this.yearsExperience = yearsExperience;
        this.managerName = managerName;
        this.HashedPw = HashedPw;
        //this.skills = new ArrayList<Skills>();
    }

    public List<Tools> getTools() {
        return tools;
    }

    public void setTools(List<Tools> tools) {
        this.tools = tools;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCurrentJobTitle() {
        return currentJobTitle;
    }

    public void setCurrentJobTitle(String currentJobTitle) {
        this.currentJobTitle = currentJobTitle;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getHashedPw() {
        return HashedPw;
    }

    public void setHashedPw(String hashedPw) {
        HashedPw = hashedPw;
    }

}