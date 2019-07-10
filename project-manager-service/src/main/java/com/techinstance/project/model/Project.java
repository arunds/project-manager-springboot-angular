package com.techinstance.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "project")
@Getter
@Setter
@EqualsAndHashCode
@JsonDeserialize(as = Project.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private User manager;
    private String title;
    private int priority;
    private String startDate;
    private String endDate;

    public Project(User manager, String title, int priority, String startDate, String endDate) {
        this.manager = manager;
        this.title = title;
        this.priority = priority;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Project() {
    }

}
