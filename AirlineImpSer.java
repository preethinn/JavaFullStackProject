package com.example.FinalProject.AirlineService;

import java.util.List;
import java.util.Optional;

import com.example.FinalProject.Ainterface.AirlineInterface;
import com.example.FinalProject.Arepository.AirlinesRepository;
import com.example.FinalProject.Entity.Airline_BluePrint;

import org.springframework.stereotype.Service;

@Service
public class AirlineImpSer implements AirlineInterface {
	
	private AirlinesRepository AirlineRepository;

	public AirlineImpSer(AirlinesRepository airlineRepository) {
		AirlineRepository = airlineRepository;
	}

	/* Method Definition */
	public Airline_BluePrint insertAirlineDetails(Airline_BluePrint booking) {
		return AirlineRepository.save(booking);
	}

	public List<Airline_BluePrint> getAllAirline_BluePrint() {
		return AirlineRepository.findAll();
	}

	public Airline_BluePrint insertEmp(Airline_BluePrint airticket) {
		return AirlineRepository.save(airticket);
	}

	public Airline_BluePrint getAirlineById(int serial_no) {
		return AirlineRepository.findById(serial_no).get();

	}

	public Airline_BluePrint updateAirlineDetails(Airline_BluePrint newFlight) {
		return AirlineRepository.save(newFlight);

	}
	
	public void deleteAirlineDetails(int serial_no) {
		AirlineRepository.deleteById(serial_no);
}

}
