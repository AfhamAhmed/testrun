package org.utdallas.atos.training.recommendationengine.model;

import javax.persistence.*;

@Entity
@Table(name = "references")
public class References
{
	@Id
	@Column(name = "Ref_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Ref_Name")
	private String name;

	@Column(name = "Ref_Description")
	private String description;

	@Column(name = "Ref_URL")
	private String url;

	protected References()
	{
	}

	public References(String name, String description, String url)
	{
		this.name = name;
		this.description = description;
		this.url = url;
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

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}
}
