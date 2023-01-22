package com.tripmaster.service;

import java.util.List;

import com.tripmaster.exceptions.BusException;
import com.tripmaster.exceptions.RouteException;
import com.tripmaster.models.Route;

public interface IRouteService {

	Route addRoute(Route route);
	Route updateRoute(Integer routeId,Integer busId) throws RouteException,BusException;
	public Route removeRoute(int routeId) throws RouteException;
	public Route searchRoute(int routeId) throws RouteException;
	public List<Route> viewRouteList() throws RouteException;
}
