package com.stockmanager.fst.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.stockmanager.fst.security.entity.MyUser;

@Entity
public class ExpressionBesoin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String eb_desc;
	
	@Temporal(TemporalType.DATE)
	private Date saveDate;
	
	@Temporal(TemporalType.DATE)
	private Date lastUpDate;
	
    @ManyToOne
	@JoinColumn(name="personnel_Id")
	private MyUser personnel;
	
	@ManyToOne
	private Dept dept;

	
	@OneToMany(mappedBy = "eb") 
	private List<ExpressionBesoinProduit> ebp;
	

	
	public ExpressionBesoin() {
		
	}
	

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


	public MyUser getPersonnel() {
		return personnel;
	}


	public void setPersonnel(MyUser personnel) {
		this.personnel = personnel;
	}


	public List<ExpressionBesoinProduit> getEbp() {
		return ebp;
	}

	public void setEbp(List<ExpressionBesoinProduit> ebp) {
		this.ebp = ebp;
	}
	

	public Date getSaveDate() {
		return saveDate;
	}


	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}


	public Date getLastUpDate() {
		return lastUpDate;
	}


	public void setLastUpDate(Date lastUpDate) {
		this.lastUpDate = lastUpDate;
	}
	




	public String getEb_desc() {
		return eb_desc;
	}


	public void setEb_desc(String eb_desc) {
		this.eb_desc = eb_desc;
	}



	public Dept getDept() {
		return dept;
	}


	public void setDept(Dept dept) {
		this.dept = dept;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExpressionBesoin other = (ExpressionBesoin) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
