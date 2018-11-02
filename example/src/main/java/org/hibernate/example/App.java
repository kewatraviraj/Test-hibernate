package org.hibernate.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SqlFragmentAlias;

@Entity(name = "app")
@SecondaryTable(
	name = "app_details"
)
@SQLDelete(
	sql = "UPDATE app_details SET deleted = true WHERE id = ? "
)
@FilterDef(
	name="activeApp",
	parameters = @ParamDef(
		name="active",
		type="boolean"
	)
)
@Filter(
	name="activeApp",
	condition="{a}.active = :active and {ad}.deleted = false",
	aliases = {
		@SqlFragmentAlias( alias = "a", table= "app"),
		@SqlFragmentAlias( alias = "ad", table= "app_details"),
	}
)
public class App {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	private Long id;

	private Double amount;

	private Double rate;

	private boolean active;

	@Column(table = "app_details")
	private boolean deleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


}
