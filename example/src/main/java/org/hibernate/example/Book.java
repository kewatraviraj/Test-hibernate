/**
 * 
 */
package org.hibernate.example;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterJoinTable;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.WhereJoinTable;

/**
 * @author Dell
 *
 */
@Entity(name = "book")
@FilterDef(name = "firstAccounts", parameters = @ParamDef(name = "maxOrderId", type = "int"))
@Filter(name = "firstAccounts", condition = "order_id <= :maxOrderId")
public class Book {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	private String title;

	private String author;
	
	@OneToMany(cascade = CascadeType.ALL)
    @OrderColumn(name = "order_id")
    @FilterJoinTable(
        name="firstAccounts",
        condition="order_id <= :maxOrderId"
    )
	private List<Reader> currentWeekReaders = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Reader> getCurrentWeekReaders() {
		return currentWeekReaders;
	}

	public void setCurrentWeekReaders(List<Reader> currentWeekReaders) {
		this.currentWeekReaders = currentWeekReaders;
	}

}
