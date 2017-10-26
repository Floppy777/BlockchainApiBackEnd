package com.indo.blockchain.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Temporal;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="project")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@JsonIgnore
	@OneToOne(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
	@JoinColumn(name="created_by",referencedColumnName="id")
	private User createdBy;
	
	@OneToOne(cascade = {CascadeType.MERGE},fetch =FetchType.EAGER)
	@JoinColumn(name="categorie_id",referencedColumnName="id")
	private Categorie categorie;
	
	@OneToOne(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
	@JoinColumn(name="country_id",referencedColumnName="id")
	private Country country;
	
	@Column(name="address")
	private String address;
	
	@Column(name="transaction_hash")
	private String transactionHash;
	
	@Column(name="description")
	private String description;
	
	@Column(name="amount_total")
	private Float amountTotal;
	
	@Column(name="amount_wanted")
	private Float amountWanted;
	
	@Column(name="nb_donation")
	private Integer nbDonation;
	
	@Column(name="created_at")
	private Date createdAt;

	@Column(name="updated_at")
	private Date updatedAt;
	
	public Project() {}
	
	public Project(String name, String description, String address){
		this.name = name;
		this.address = address;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	
	public Country getCountry(){
		return country;
	}

	public void setCountry(Country country){
		this.country = country;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getCreatedAt(){
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt){
		this.createdAt = createdAt;
	}
	
	public Date getUpdatedAt(){
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt){
		this.updatedAt = updatedAt;
	}
	
	public Float getAmountTotal() {
		return amountTotal;
	}

	public void setAmountTotal(Float amountTotal) {
		this.amountTotal = amountTotal;
	}

	public Float getAmountWanted() {
		return amountWanted;
	}

	public void setAmountWanted(Float amountWanted) {
		this.amountWanted = amountWanted;
	}

	public Integer getNbDonation() {
		return nbDonation;
	}

	public void setNbDonation(Integer nbDonation) {
		this.nbDonation = nbDonation;
	}

	public String getTransactionHash() {
		return transactionHash;
	}

	public void setTransactionHash(String transactionHash) {
		this.transactionHash = transactionHash;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", createdBy=" + createdBy + ", categorie=" + categorie
				+ ", country=" + country + ", address=" + address + ", description=" + description + ", amountTotal="
				+ amountTotal + ", amountWanted=" + amountWanted + ", nbDonation=" + nbDonation + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}	
}
