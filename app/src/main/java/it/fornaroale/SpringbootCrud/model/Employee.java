package it.fornaroale.SpringbootCrud.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emptab")
public class Employee {

    @Id
    @Column(name = "eid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @Column(name = "ename")
    private String empName;

    @Column(name = "egen")
    private String empGen;

    @Column(name = "edept")
    private String empDept;

    @Column(name = "esal")
    private Double empSal;

    @Column(name = "email")
    private String email;

    @DateTimeFormat(iso = ISO.DATE)
    @Temporal(TemporalType.DATE)
    @Column(name = "Doj")
    private Date empDoj;
}