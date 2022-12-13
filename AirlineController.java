package com.example.FinalProject.Controller;

import com.example.FinalProject.Ainterface.AirlineInterface;
import com.example.FinalProject.Entity.Admin;
import com.example.FinalProject.Entity.Airline_BluePrint;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AirlineController {
	
	AirlineInterface airlineService;

	public AirlineController(AirlineInterface airlineService) {
		this.airlineService = airlineService;
	}

	@GetMapping("/ViewAllFlights")
	public String viewAllFlights(Model model) {
		model.addAttribute("FlightList", airlineService.getAllAirline_BluePrint());
		return "FlightDetails";
		//return "LobbyPage";
	}

	@GetMapping("/addFlight")
	public String addFlight(Model model) {
		Airline_BluePrint airline = new Airline_BluePrint();
		model.addAttribute("FlightDetails", airline);
		return "addflightdetails";
	}

	@PostMapping("/Insertion")
	public String insertAndSave(@ModelAttribute("FlightDetails") Airline_BluePrint flightDetailsFromAdmin) {
		airlineService.insertAirlineDetails(flightDetailsFromAdmin);
		return "redirect:/ViewAllFlights";
	}

	@GetMapping("/ViewAllFlights/edit/{serial_no}")
	public String editEmp(@PathVariable int serial_no, Model model) {
		model.addAttribute("flightDetailsFromAdmin", airlineService.getAirlineById(serial_no));
		return "viewOneFlight";
	}

	@PostMapping("/update/{serial_no}")
	public String updateEmp(@PathVariable int serial_no,
			@ModelAttribute("flightDetailsFromAdmin") Airline_BluePrint fromFrontEnd, Model model) {
		Airline_BluePrint presentObj = airlineService.getAirlineById(serial_no);
		presentObj.setSerial_no(serial_no);
		presentObj.setAirline_Code(fromFrontEnd.getAirline_Code());
		presentObj.setDestination(fromFrontEnd.getDestination());
		presentObj.setFlight_Name(fromFrontEnd.getFlight_Name());
		presentObj.setFlight_Type(fromFrontEnd.getFlight_Type());
		presentObj.setStart_Point(fromFrontEnd.getStart_Point());
		airlineService.updateAirlineDetails(presentObj);
		return "redirect:/ViewAllFlights";
	}

	@GetMapping("/deleteAirlineDetails/{serial_no}")
	public String deleteAirlineDetails(@PathVariable int serial_no) {
		airlineService.deleteAirlineDetails(serial_no);
		return "redirect:/ViewAllFlights";
	}

	@GetMapping("/LogoutFromWeb")
	public String logoutfromWeb() {
		return "Logout";
	}

	@GetMapping("/LoginFromWeb")
	public String loginToWeb(Model model) {
		Admin userobj = new Admin();
		model.addAttribute("adminobject", userobj);
		return "SigninPage";
	}

	@GetMapping("/validate")
	public String validation(@ModelAttribute("adminobject") Admin adminobj) {
		if (adminobj.getAdminUsername().equals("Preethi") 
				&& adminobj.getPassword().equals("pree")) {
			return "redirect:/LobbyScreen";

		}
		return "redirect:/LoginFromWeb";
	}
	
	@GetMapping("/LobbyScreen")
	public String Lobby() {
			return "LobbyPage";
		}
		
	

}
