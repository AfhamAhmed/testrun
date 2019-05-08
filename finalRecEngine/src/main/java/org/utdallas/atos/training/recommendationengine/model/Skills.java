package org.utdallas.atos.training.recommendationengine.model;
import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.List;

@Entity
@Table(name="skills")
public class Skills
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Skill_Id")
	private Long id;

	@Column(name = "Skill_Name")
	private String name;

	@Column(name = "Skill_Domain")
	private String domain;

	@Column(name = "Skill_Subdomain")
	private String subDomain;

	@Column(name = "Skill_Description")
	private String description;

	@Column(name = "Skill_Level")
	private String level;

	@Column(name = "Skill_Course_ID")
	private int courseID;

	@ManyToMany(mappedBy = "skills")
	private List<Jobs>  jobs;


	@ManyToMany(mappedBy = "skills")
	private List<Employees>  employees;

	public List<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Jobs> getJobs() {
		return jobs;
	}

	public void setJobs(List<Jobs> jobs) {
		this.jobs = jobs;
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

	public String getDomain()
	{
		return domain;
	}

	public void setDomain(String domain)
	{
		this.domain = domain;
	}

	public String getSubDomain()
	{
		return subDomain;
	}

	public void setSubDomain(String subDomain)
	{
		this.subDomain = subDomain;
	}

	public String getLevel()
	{
		return level;
	}

	public void setLevel(String level)
	{
		this.level = level;
	}

	public int getCourseID()
	{
		return courseID;
	}

	public void setCourseID(int courseID)
	{
		this.courseID = courseID;
	}

	public LinkedHashMap<String,Object> convertToHashMap()
	{
		LinkedHashMap<String,Object> returnMap = new LinkedHashMap<>();
		returnMap.put("Name",name);
		returnMap.put("Description",description);
		returnMap.put("Skill Level",level);
		return returnMap;
	}
}