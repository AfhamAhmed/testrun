package org.utdallas.atos.training.recommendationengine.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Entity
@Table(name="tools")
public class Tools
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Tool_ID")
	private Long id;

	@Column(name = "Tool_Name")
	private String name;

	@Column(name = "Tool_Description")
	private String description;

	@Column(name = "Tool_Domain")
	private String domain;

	@Column(name = "Tool_Subdomain")
	private String subDomain;

	@Column(name = "Tool_Level")
	private String level;

	@Column(name = "Tool_Course_ID")
	private int courseID;

	@ManyToMany(mappedBy = "tools")
	private List<Jobs> jobs;


	@ManyToMany(mappedBy = "tools")
	private List<Employees> employees;


	public List<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getSubDomain() {
		return subDomain;
	}

	public void setSubDomain(String subDomain) {
		this.subDomain = subDomain;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public List<Jobs> getJobs() {
		return jobs;
	}

	public void setJobs(List<Jobs> jobs) {
		this.jobs = jobs;
	}

	public LinkedHashMap<String,Object> convertToHashMap()
	{
		LinkedHashMap<String,Object> returnMap = new LinkedHashMap<>();
		returnMap.put("Name",name);
		returnMap.put("Description",description);
		returnMap.put("Level",level);
		return returnMap;
	}
}