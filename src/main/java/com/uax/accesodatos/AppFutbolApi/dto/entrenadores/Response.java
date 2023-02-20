package com.uax.accesodatos.AppFutbolApi.dto.entrenadores;

import java.util.ArrayList;

public class Response{
    public int id;
    public String name;
    public String firstname;
    public String lastname;
    public int age;
    public Birth birth;
    public String nationality;
    public String height;
    public String weight;
    public String photo;
    public Team team;
    public ArrayList<Career> career;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Birth getBirth() {
		return birth;
	}
	public void setBirth(Birth birth) {
		this.birth = birth;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public ArrayList<Career> getCareer() {
		return career;
	}
	public void setCareer(ArrayList<Career> career) {
		this.career = career;
	}
    
    
}
