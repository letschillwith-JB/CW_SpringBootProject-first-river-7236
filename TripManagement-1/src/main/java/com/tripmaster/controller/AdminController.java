package com.tripmaster.controller;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tripmaster.exceptions.AdminException;
import com.tripmaster.exceptions.HotelException;
import com.tripmaster.exceptions.PackageException;
import com.tripmaster.exceptions.ReportException;
import com.tripmaster.exceptions.RouteException;
import com.tripmaster.exceptions.TicketDetailsException;
import com.tripmaster.exceptions.TravelsException;
import com.tripmaster.models.Admin;
import com.tripmaster.models.AdminSigninDTO;
import com.tripmaster.models.FullPackageDTO;
import com.tripmaster.models.Hotel;
import com.tripmaster.models.PackageDTO;
import com.tripmaster.models.Packages;
import com.tripmaster.models.Report;
import com.tripmaster.models.Route;
import com.tripmaster.models.TicketDetails;
import com.tripmaster.models.Travels;
import com.tripmaster.service.AdminLoginService;
import com.tripmaster.service.AdminService;
import com.tripmaster.service.BusService;
import com.tripmaster.service.HotelService;
import com.tripmaster.service.IPackageService;
import com.tripmaster.service.IReportService;
import com.tripmaster.service.IRouteService;
import com.tripmaster.service.ITravelsService;
import com.tripmaster.service.TicketService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired 
	private IPackageService packageService;
	@Autowired 
	private HotelService hotelService;
	@Autowired 
	private IRouteService routeService;
	@Autowired 
	private BusService busService;
	@Autowired 
	private ITravelsService travelsService;
	@Autowired 
	private TicketService ticketService;
	@Autowired 
	private IReportService reportService;
	@Autowired 
	private AdminService adminService;
	@Autowired 
	private AdminLoginService adminLoginService;
	
	
	@PostMapping("/")
	public ResponseEntity<Admin> saveAdmin(@RequestBody AdminSigninDTO admin) throws AdminException {
		Admin savedAdmin = adminService.createAdmin(admin);
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.OK);
	}
	

	// to update admin by passing key	
	@PutMapping("/update")
	public ResponseEntity<Admin> updateAdmin(@RequestBody AdminSigninDTO admin, @RequestParam(required = false) String key) throws LoginException {
		adminLoginService.isLoggedInByUUID(key);
		return new ResponseEntity<Admin>(adminService.updateAdmin(admin, key),HttpStatus.OK);
	}
	
	
	
	@PostMapping("/packages/{adminId}")
	public ResponseEntity<Packages> addPackages(@RequestBody PackageDTO packages,@PathVariable Integer adminId) throws LoginException{
		adminLoginService.isLoggedIn(adminId);
		Packages packages2 = packageService.addPackage(packages);
		return new ResponseEntity<Packages>(packages2,HttpStatus.OK);
	}
	
	@PostMapping("/createFullPackage/{adminId}")
	public ResponseEntity<Packages> createFullPackage(@RequestBody FullPackageDTO packages,@PathVariable Integer adminId) throws LoginException{
		adminLoginService.isLoggedIn(adminId);
		Packages packages2 = packageService.addPackage(packages);
		return new ResponseEntity<Packages>(packages2,HttpStatus.OK);
	}
	
	
	@PutMapping("/addHotelToPackage/{packageid}/{hotelid}/{adminId}")
	public ResponseEntity<Packages> addHotelToPackage(@PathVariable("packageid") Integer packageId ,@PathVariable("hotelid") Integer hotelId, @PathVariable("adminId") Integer adminID ) throws PackageException, HotelException, LoginException{
		adminLoginService.isLoggedIn(adminID);
		Packages packages2 = packageService.addHotelToPackage(packageId,hotelId);
		return new ResponseEntity<Packages>(packages2,HttpStatus.OK);
	}
	
	@PostMapping("/hotels/{adminId}")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel,@PathVariable Integer adminId) throws LoginException{
		adminLoginService.isLoggedIn(adminId);
		Hotel hotel2 = hotelService.addHotel(hotel);
		return new ResponseEntity<Hotel>(hotel2,HttpStatus.OK);
	}
	
	@PostMapping("/bustTicket/{adminId}")
	public ResponseEntity<TicketDetails> addBusTicket(@RequestBody TicketDetails ticketDetails,@PathVariable Integer adminId) throws LoginException{
		adminLoginService.isLoggedIn(adminId);
		TicketDetails ticketDetails2 = ticketService.addBusTicket(ticketDetails);
		return new ResponseEntity<TicketDetails>(ticketDetails2,HttpStatus.OK);
	}
	
	
	@PostMapping("/routes")
	public ResponseEntity<Route> addRoute(@RequestBody Route route){
		Route route2 = routeService.addRoute(route);
		return new ResponseEntity<Route>(route2,HttpStatus.OK);
	}
	
	@PutMapping("/addTicketDetailsToPackages/{ticketId}/{packageId}")
	public ResponseEntity<Packages> updateRoute(@PathVariable("ticketId") Integer ticketId,@PathVariable("packageId") Integer packageId) throws TicketDetailsException, PackageException{
		Packages packages = packageService.updatePackages(ticketId,packageId);
		return new ResponseEntity<Packages>(packages,HttpStatus.OK);
	}
	
	@PostMapping("/report/{adminId}")
	public ResponseEntity<Report> createReport(@RequestBody Report report,@PathVariable("adminId") Integer adminId) throws AdminException, LoginException{
		adminLoginService.isLoggedIn(adminId);
		Report savedReport = reportService.addReport(report,adminId);
		return new ResponseEntity<Report>(savedReport, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/report/{reportId}")
	public ResponseEntity<Report> deleteReport(@PathVariable("reportId") Integer id) throws ReportException{
		Report report = reportService.deleteReport(id);
		return new ResponseEntity<Report>(report, HttpStatus.OK);
	}	
	
	@GetMapping("/report/{reportId}")
	public ResponseEntity<Report> getReport(@PathVariable("reportId") Integer id) throws ReportException {
		Report report = reportService.viewReport(id);
		return new ResponseEntity<Report>(report, HttpStatus.OK);
	}

	@GetMapping("/packagesViewAll")
	public ResponseEntity<List<Packages>> viewAllPackages() throws PackageException{
		List<Packages> packages=packageService.viewAllPackage();
		return new ResponseEntity<List<Packages>>(packages,HttpStatus.OK);
	}
	
	@GetMapping("/packagesView{packageId}")
	public ResponseEntity<Packages> searchPackages(@PathVariable int packageId) throws PackageException{
		Packages packages=packageService.searchPackage(packageId);
		return new ResponseEntity<Packages>(packages,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePackage{packageId}")
	public ResponseEntity<Packages> deletePackageById(@PathVariable int packageId) throws PackageException{
		Packages packages=packageService.deletePackage(packageId);
		return new ResponseEntity<Packages>(packages,HttpStatus.OK);
	}
	
	@GetMapping("/reports/{adminId}")
	public ResponseEntity<List<Report>> getAllReports(@PathVariable Integer adminID) throws ReportException, LoginException {
		adminLoginService.isLoggedIn(adminID);
		
		List<Report> reportList = reportService.viewAllReports();
		return new ResponseEntity<List<Report>>(reportList, HttpStatus.OK);
	}
	
	@GetMapping("/routes")
	public ResponseEntity<List<Route>> getAllRoutes() throws RouteException{
		List<Route> routeList = routeService.viewRouteList();
		return new ResponseEntity<List<Route>>(routeList,HttpStatus.OK);
	}
	
	@DeleteMapping("/routes/{routeId}")
	public ResponseEntity<Route> removeRoute(@PathVariable("routeId") int routeId) throws RouteException{
		Route route = routeService.removeRoute(routeId);
		return new ResponseEntity<Route>(route,HttpStatus.OK);
	}
	
	@GetMapping("/routes/{routeId}")
	public ResponseEntity<Route> searchRoute(@PathVariable("routeId") int routeId) throws RouteException{
		Route route = routeService.searchRoute(routeId);
		return new ResponseEntity<Route>(route,HttpStatus.FOUND);
	}
	
	@PostMapping("/travels")
	public ResponseEntity<Travels> addTravles(@RequestBody Travels travels) throws TravelsException{
		Travels travels2 = travelsService.addTravels(travels); 
		return new ResponseEntity<Travels>(travels2,HttpStatus.OK);
	}
	
	@GetMapping("/travels")
	public ResponseEntity<List<Travels>> allTravles(@RequestBody Travels travels) throws TravelsException{
		List<Travels> travelsList = travelsService.viewTravels(); 
		return new ResponseEntity<List<Travels>>(travelsList,HttpStatus.OK);
	}
	
	@PutMapping("/travels")
	public ResponseEntity<Travels> updateTravels(@RequestBody Travels travels) throws TravelsException{
		Travels travels2 = travelsService.updateTravels(travels);
		return new ResponseEntity<Travels>(travels2,HttpStatus.OK);
	}

}
