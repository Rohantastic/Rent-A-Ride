package com.app.RentARide.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "billdetails")
public class BillingDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@Size(min = 2, max = 10, message = "First Name length should be minimum 2 characters and maximum 10")
	@Column(nullable = false, name = "fname")
	private String firstName;

	@NotNull
	@Size(min = 2, max = 10, message = "First Name length should be minimum 2 characters and maximum 10")
	@Column(nullable = false, name = "lname")
	private String lastName;
	@NotNull
	@Size(message = "Field should not be empty")
	@Column(nullable = false)
	private String Adrressp1;

	@NotNull
	@Size(message = "Field should not be empty")
	@Column(nullable = false)
	private String Adrressp2;

	@NotNull
	@Size(min = 2, max = 10, message = "First Name length should be minimum 2 characters and maximum 10")
	@Column(nullable = false)
	private String postcode;

	@NotNull
	@Size(message = "Field should not be empty")
	@Column(nullable = false)
	private String city;

	private long phoneNo;

	@NotEmpty(message = "Email field should not be empty give email like abc@gmail.com")
	@Email(regexp = "^(.+)@(.+)$", message = "Invalid email pattern")
	@Column(nullable = false)
	private String Email;

	@Column(nullable = false)
	private String AddInfo;

	@Column(nullable = false)
	private double tAmount;

	@Column(nullable = false)
	private double pAmount;

	public BillingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillingDetails(int id, String firstName, String lastName, String adrressp1, String adrressp2,
			String postcode, String city, long phoneNo, String email, String addInfo, double tAmount, double pAmount) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		Adrressp1 = adrressp1;
		Adrressp2 = adrressp2;
		this.postcode = postcode;
		this.city = city;
		this.phoneNo = phoneNo;
		Email = email;
		AddInfo = addInfo;
		this.tAmount = tAmount;
		this.pAmount = pAmount;
	}

	public BillingDetails(String firstName, String lastName, String adrressp1, String adrressp2, String postcode,
			String city, long phoneNo, String email, String addInfo, double tAmount, double pAmount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Adrressp1 = adrressp1;
		Adrressp2 = adrressp2;
		this.postcode = postcode;
		this.city = city;
		this.phoneNo = phoneNo;
		Email = email;
		AddInfo = addInfo;
		this.tAmount = tAmount;
		this.pAmount = pAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdrressp1() {
		return Adrressp1;
	}

	public void setAdrressp1(String adrressp1) {
		Adrressp1 = adrressp1;
	}

	public String getAdrressp2() {
		return Adrressp2;
	}

	public void setAdrressp2(String adrressp2) {
		Adrressp2 = adrressp2;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddInfo() {
		return AddInfo;
	}

	public void setAddInfo(String addInfo) {
		AddInfo = addInfo;
	}

	public double gettAmount() {
		return tAmount;
	}

	public void settAmount(double tAmount) {
		this.tAmount = tAmount;
	}

	public double getpAmount() {
		return pAmount;
	}

	public void setpAmount(double pAmount) {
		this.pAmount = pAmount;
	}

	@Override
	public String toString() {
		return "BillingDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Adrressp1="
				+ Adrressp1 + ", Adrressp2=" + Adrressp2 + ", postcode=" + postcode + ", city=" + city + ", phoneNo="
				+ phoneNo + ", Email=" + Email + ", AddInfo=" + AddInfo + ", tAmount=" + tAmount + ", pAmount="
				+ pAmount + "]";
	}

}
