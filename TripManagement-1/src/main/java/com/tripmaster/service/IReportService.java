package com.tripmaster.service;

import java.util.List;

import com.tripmaster.exceptions.AdminException;
import com.tripmaster.exceptions.ReportException;
import com.tripmaster.models.Report;

public interface IReportService {

	public Report addReport(Report report,Integer adminId)throws AdminException;
	public Report deleteReport(Integer id)throws ReportException;
	public Report viewReport(Integer id)throws ReportException;
	public List<Report> viewAllReports()throws ReportException;
}
