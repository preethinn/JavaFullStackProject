package com.example.FinalProject.Ainterface;

import java.util.List;
import com.example.FinalProject.Entity.Airline_BluePrint;

public interface AirlineInterface {

	
	// CRUD: Insertion
	Airline_BluePrint insertAirlineDetails(Airline_BluePrint airticket);

	// CRUD: Read /View
	List<Airline_BluePrint> getAllAirline_BluePrint();

	// CRUD : Update
	Airline_BluePrint getAirlineById(int serial_no);

	Airline_BluePrint updateAirlineDetails(Airline_BluePrint newFlight);
	/* newFlight will hold the new updated values */
	
	
	/*CRUD:Delete*/
	void deleteAirlineDetails(int serial_no);

}
