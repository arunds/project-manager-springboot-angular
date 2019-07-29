package com.techinstance.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "project")
@Getter
@Setter
@JsonDeserialize(as = Project.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tasks"})
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@ManyToOne
	@JoinColumn(name = "MANAGER_ID")
    private User manager;
    private String title;
    private int priority;
    private String startDate;
    private String endDate;
    @OneToMany(mappedBy = "project")
    private Set<Task> tasks = new HashSet<>();
    @Transient
    private int noOfTasks;
    @Transient
    private int completed;

    public Project(User manager, String title, int priority, String startDate, String endDate) {
        this.manager = manager;
        this.title = title;
        this.priority = priority;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public Project() {
    }

    public int getNoOfTasks() {
		this.noOfTasks = getTasks().size();
		return noOfTasks;
	}

	public int getCompleted() {

		int count = 0;
		for (Task task : tasks) {
			if (task.getStatus() == "ENDED") {
				count++;
			}
		}
		this.completed = count;

		return completed;
	}
    
}
