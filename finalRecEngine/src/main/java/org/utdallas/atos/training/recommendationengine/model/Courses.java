package org.utdallas.atos.training.recommendationengine.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Courses
{

	@Id
	@Column(name = "Course_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long courseId;

	@Column(name = "Course_Name")
	private String name;

	@Column(name = "Course_Description")
	private String description;

	@Column(name = "Course_Provider")
	private String provider;

	@Column(name = "Course_URL")
	private String url;

	@Column(name = "Course_Duration")
	private String duration;

	@Column(name = "Course_Level")
	private String level;

	@Column(name = "Course_Fee")
	private String fee;

	protected Courses()
	{
	}

	public Courses(String name, String description, String provider, String url, String duration, String level, String fee)
	{
		this.name = name;
		this.description = description;
		this.provider = provider;
		this.url = url;
		this.duration = duration;
		this.level = level;
		this.fee = fee;
	}

	public long getCourseId()
	{
		return courseId;
	}

	public void setCourseId(long courseId)
	{
		this.courseId = courseId;
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

	public String getProvider()
	{
		return provider;
	}

	public void setProvider(String provider)
	{
		this.provider = provider;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getDuration()
	{
		return duration;
	}

	public void setDuration(String duration)
	{
		this.duration = duration;
	}

	public String getLevel()
	{
		return level;
	}

	public void setLevel(String level)
	{
		this.level = level;
	}

	public String getFee()
	{
		return fee;
	}

	public void setFee(String fee)
	{
		this.fee = fee;
	}
}
