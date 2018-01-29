package fr.mds.exos.supcommerce.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="category")
public class CategoryEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	
	public CategoryEntity(long id, String name) {
		this.id = id;
		this.name = name;
	}
	public CategoryEntity(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
