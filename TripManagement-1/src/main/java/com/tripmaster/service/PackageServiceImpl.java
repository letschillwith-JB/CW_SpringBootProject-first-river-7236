package com.tripmaster.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaster.exceptions.HotelException;
import com.tripmaster.exceptions.PackageException;
import com.tripmaster.exceptions.TicketDetailsException;
import com.tripmaster.models.FullPackageDTO;
import com.tripmaster.models.Hotel;
import com.tripmaster.models.PackageDTO;
import com.tripmaster.models.Packages;
import com.tripmaster.models.TicketDetails;
import com.tripmaster.repository.HotelDao;
import com.tripmaster.repository.PackageDao;
import com.tripmaster.repository.TicketDetailsDao;

@Service
public class PackageServiceImpl implements IPackageService{
	
	@Autowired 
	private PackageDao packageDao;
	@Autowired 
	private HotelDao hotelDao;
	@Autowired 
	private TicketDetailsDao ticketDetailsDao;

	@Override
	public Packages addPackage(PackageDTO packageDto) {
		Packages packages = new Packages();
		packages.setPackageName(packageDto.getPackageName());
		packages.setPackageType(packageDto.getPackageType());
		packages.setPackageCost(packageDto.getPackageCost());
		packages.setPackageDescription(packageDto.getPackageDescription());
		return packageDao.save(packages);
	}
	
	@Override
	public Packages addPackage(FullPackageDTO packages) {
		Packages newPackages = new Packages();
		newPackages.setPackageName(packages.getPackageName());
		newPackages.setPackageType(packages.getPackageType());
		newPackages.setPackageCost(packages.getPackageCost());
		newPackages.setHotels(packages.getHotels());
		newPackages.setTicketDetail(packages.getTicketDetails());
		return packageDao.save(newPackages);
	}
	
	
	@Override
	public Packages addHotelToPackage(Integer packageId,Integer hotelId) throws PackageException,HotelException{
		Optional<Packages> opt = packageDao.findById(packageId);
		Optional<Hotel> opt2 = hotelDao.findById(hotelId);
		if(opt.isPresent()) {
			if(opt2.isPresent()) {
			Packages packages2 = opt.get();
			Hotel hotel = opt2.get();
			packages2.getHotels().add(hotel);
			packages2.setPackageCost(packages2.getPackageCost()+hotel.getRent());
			return packageDao.save(packages2);
			}
			else throw new HotelException("hotel not found");
		}
		else throw new PackageException("no packages exists with packagesId:"+packageId);
	}
	
	
	@Override
	public Packages updatePackages(Integer ticketId,Integer packageId) throws TicketDetailsException,PackageException{
		Optional<TicketDetails> opt = ticketDetailsDao.findById(ticketId);
		Optional<Packages> opt2 = packageDao.findById(packageId);
		if(opt.isPresent()) {
			if(opt2.isPresent()) {
				TicketDetails ticketDetails = opt.get();
				Packages packages = opt2.get();
				packages.setTicketDetail(ticketDetails);
				return packageDao.save(packages);
			}
			else throw new PackageException("package not found");
		}
		else throw new TicketDetailsException("ticket details not found");
	}
	

	@Override
	public Packages deletePackage(int packageId) throws PackageException {
		Optional<Packages> opackages=packageDao.findById(packageId);
		if (opackages.isEmpty()) {
			throw new PackageException("This Package Not Found to Delete"+packageId);
		}
		packageDao.delete(opackages.get());
		return opackages.get();
	}

	@Override
	public List<Packages> viewAllPackage() throws PackageException {
		List<Packages> packages=packageDao.findAll();
		if (packages.isEmpty()) {
			throw new PackageException("No Package is There to display");
		}
		return packages;
	}

	@Override
	public Packages searchPackage(int packageId) throws PackageException {
		Optional<Packages> opackages=packageDao.findById(packageId);
		if (opackages.isEmpty()) {
			throw new PackageException("This Package Not Found to Show"+packageId);
		}
		return opackages.get();
	}
}
