package com.indo.blockchain.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="cellphone_number")
	private String cellphoneNumber;
	
	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_roles",
			joinColumns={@JoinColumn(name="user_id",referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="role_id",referencedColumnName="id")})
	private Set<Role> role;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="account_id",referencedColumnName="id")
	private Account account;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="ethereum_account_id",referencedColumnName="id")
	private EthereumAccount ethereumAccount;
	
	public User(){}
	
	public User(String lastname,String firstname,String mail,Set<Role> role){
		this.lastname = lastname;
		this.firstname = firstname;
		this.mail = mail;
		this.role = role;
		this.createdAt = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getCreatedAt(){
		return this.createdAt;
	}
	
	public void setCreatedAt(Date date){
		this.createdAt = date;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}
	
	public Account getAccount(){
		return account;
	}
	
	public void setAccount(Account account){
		this.account = account;
	}
	
	public EthereumAccount getEthereumAccount() {
		return ethereumAccount;
	}

	public void setEthereumAccount(EthereumAccount ethereumAccount) {
		this.ethereumAccount = ethereumAccount;
	}

	public String getCellphoneNumber() {
		return cellphoneNumber;
	}

	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", mail=" + mail
				+ ", cellphoneNumber=" + cellphoneNumber + ", createdAt=" + createdAt + ", role=" + role + ", account="
				+ account + ", ethereumAccount=" + ethereumAccount + "]";
	}
}
