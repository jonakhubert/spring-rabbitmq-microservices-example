package com.mycompany.employee;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "employees")
public class Employee {

    @Id
    private String id;

    @NotEmpty
    @NotBlank
    private String firstName;

    @NotEmpty
    @NotBlank
    private String lastName;

    @Positive
    @Min(18)
    @Max(65)
    private int age;

    @Email
    private String email;

    @NotEmpty
    @NotBlank
    private String position;

    @CreatedDate
    private Date addedDate;

    public Employee() {}

    public Employee(String id, String firstName, String lastName, int age, String email, String position, Date addedDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.position = position;
        this.addedDate = addedDate;
    }

    // getters
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public String getPosition() { return position; }
    public Date getAddedDate() { return addedDate; }

    // setters
    public void setId(String id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAge(int age) { this.age = age; }
    public void setEmail(String email) { this.email = email; }
    public void setPosition(String position) { this.position = position; }
    public void setAddedDate(Date addedDate) { this.addedDate = addedDate; }
}
