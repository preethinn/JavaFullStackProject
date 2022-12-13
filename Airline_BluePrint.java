package com.example.FinalProject.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "airline_ticketing_system")
public class Airline_BluePrint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serial_no;

	@Column(name = "airline_code", nullable = false)
	@Pattern(regexp="^[A-P0-9]{6}",message="length must be 6")
	private String airline_Code;

	@Column(name = "flight_name", nullable = false)
	private String flight_Name;

	@Column(name = "destination", nullable = false)
	private String destination;

	@Column(name = "flight_type", nullable = false)
	private String flight_Type;

	@Column(name = "strat_point", nullable = false)
	@Size(max=10,min=5,message="criteria not met")
	private String start_Point;

	public Airline_BluePrint() {
	}

	public Airline_BluePrint(int serial_no, String airline_Code, String flight_Name, String destination,
			String flight_Type, String start_Point) {	
		this.serial_no = serial_no;
		this.airline_Code = airline_Code;
		this.flight_Name = flight_Name;
		this.destination = destination;
		this.flight_Type = flight_Type;
		this.start_Point = start_Point;
	}

	public int getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(int serial_no) {
		this.serial_no = serial_no;
	}

	public String getAirline_Code() {
		return airline_Code;
	}

	public void setAirline_Code(String airline_Code) {
		this.airline_Code = airline_Code;
	}

	public String getFlight_Name() {
		return flight_Name;
	}

	public void setFlight_Name(String flight_Name) {
		this.flight_Name = flight_Name;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFlight_Type() {
		return flight_Type;
	}

	public void setFlight_Type(String flight_Type) {
		this.flight_Type = flight_Type;
	}

	public String getStart_Point() {
		return start_Point;
	}

	public void setStart_Point(String start_Point) {
		this.start_Point = start_Point;
	}



}
