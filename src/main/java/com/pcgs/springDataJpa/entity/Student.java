package com.pcgs.springDataJpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(name="enrollment_id", nullable=false, unique=true)
    private String enrollmentId;

    public Student() {}
    public Student(String name, String enrollmentId) {
        this.name = name;
        this.enrollmentId = enrollmentId;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", enrollmentId=" + enrollmentId + "]";
    }
}
