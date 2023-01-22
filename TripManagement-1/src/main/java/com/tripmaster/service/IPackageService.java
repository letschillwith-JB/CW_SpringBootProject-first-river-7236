package com.tripmaster.service;

import java.util.List;

import com.tripmaster.exceptions.HotelException;
import com.tripmaster.exceptions.PackageException;
import com.tripmaster.exceptions.TicketDetailsException;
import com.tripmaster.models.FullPackageDTO;
import com.tripmaster.models.PackageDTO;
import com.tripmaster.models.Packages;

public interface IPackageService {

	public Packages addPackage(PackageDTO packages);
	public Packages addPackage(FullPackageDTO packages);
	public Packages addHotelToPackage(Integer packageID,Integer hotelId) throws PackageException,HotelException;
	public Packages updatePackages(Integer ticketId,Integer packageId) throws TicketDetailsException,PackageException;
	public Packages deletePackage(int packageId)throws PackageException;
	public List<Packages> viewAllPackage()throws PackageException;
	public Packages searchPackage(int packageId)throws PackageException;
}
