package com.joerajeev.carsales.dto;

public class CreateAdDTO {

	private String reg;
	private int year;
	private int milage;
	private String colour;
	private String make;
	private String model;
	
	private String ownerName;
	private String phone;
	
	/**
	 * @return the reg
	 */
	public String getReg() {
		return reg;
	}
	/**
	 * @param reg the reg to set
	 */
	public void setReg(String reg) {
		this.reg = reg;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the milage
	 */
	public int getMilage() {
		return milage;
	}
	/**
	 * @param milage the milage to set
	 */
	public void setMilage(int milage) {
		this.milage = milage;
	}
	/**
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}
	/**
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}
	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the owner
	 */
	public String getOwnerName() {
		return ownerName;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwnerName(String owner) {
		this.ownerName = owner;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CreateAdDTO [reg=" + reg + ", year=" + year + ", milage=" + milage + ", colour=" + colour + ", make="
				+ make + ", model=" + model + ", ownerName=" + ownerName + ", phone=" + phone + "]";
	}
	
}
