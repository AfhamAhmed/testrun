package org.utdallas.atos.training.recommendationengine.model;

import javax.persistence.*;

import java.util.List;


@Entity
@Table(name = "jobs")
public class Jobs
{
	@Id
	@Column(name = "Job_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Job_Name")
	private String name;

	@Column(name = "Job_Description")
	private String description;

	@Column(name = "Years_Experience")
	private long yearsExperience;

	@ManyToMany
	@JoinTable(name = "job_skill_requirements",
			joinColumns = @JoinColumn(name = "JSR_Job_ID"),
			inverseJoinColumns = @JoinColumn(name = "JSR_Skill_ID"))
	private List<Skills> skills;

	@ManyToMany
	@JoinTable(name = "job_tool_requirements",
			joinColumns = @JoinColumn(name = "JTR_Job_ID", referencedColumnName = "Job_ID"),
			inverseJoinColumns = @JoinColumn(name = "JTR_Tool_ID", referencedColumnName = "Tool_ID"))

	private List<Tools> tools;

	protected Jobs()
	{
	}

	public Jobs(String name){
		this.name = name;
	}

	public Jobs(String name, List<Tools> tools){
		this.name = name;
		this.tools = tools;
	}

	public Jobs(String name, String description, long yearsExperience)
	{
		this.name = name;
		this.description = description;
		this.yearsExperience = yearsExperience;
	}

	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}

	public List<Tools> getTools() {
		return tools;
	}

	public void setTools(List<Tools> tools) {
		this.tools = tools;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public long getYearsExperience()
	{
		return yearsExperience;
	}

	public void setYearsExperience(long yearsExperience)
	{
		this.yearsExperience = yearsExperience;
	}
}
