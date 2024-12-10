package com.mycorp.birdobs.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycorp.birdobs.dao.ReportDao;
import com.mycorp.birdobs.dto.ReportDto;
import com.mycorp.birdobs.models.Report;

@Service
public class ReportService {

    @Autowired
    ReportDao reportDao;

    public ReportDto save(ReportDto reportDto) {
        Report report = toEntity(reportDto);

        Report savedReport = reportDao.save(report);

        return toDto(savedReport);
    }

    public ReportDto findById(Integer id) {
        Optional<Report> reportInDb = reportDao.findById(id);

        if (!reportInDb.isPresent()) {
            return null;
        }

        return toDto(reportInDb.get());
    }

    private Report findReportById(Integer id) {
        Optional<Report> reportInDb = reportDao.findById(id);

        if (!reportInDb.isPresent()) {
            return null;
        }

        return reportInDb.get();
    }

    public ReportDto updateById(Integer id, ReportDto report) {
        Report reportInDb = findReportById(id);

        if (reportInDb == null) {
            return null;
        }

        // Mettre à jour les champs nécessaires
        if (report.getNom() != null) {
            reportInDb.setNom(report.getNom());
        }
        if (report.getEspece() != null) {
            reportInDb.setEspece(report.getEspece());
        }
        if (report.getNombre() != null) {
            reportInDb.setNombre(report.getNombre());
        }
        if (report.getVille() != null) {
            reportInDb.setVille(report.getVille());
        }

        Report updatedReport = reportDao.save(reportInDb);

        return toDto(updatedReport);
    }

    public boolean deleteById(Integer id) {
        Report reportInDb = findReportById(id);

        if (reportInDb == null) {
            return false;
        }

        reportDao.delete(reportInDb);

        return true;
    }

    private Report toEntity(ReportDto reportDto) {
        Report report = new Report();

        report.setReportID(reportDto.getReportID());
        report.setNom(reportDto.getNom());
        report.setEspece(reportDto.getEspece());
        report.setNombre(reportDto.getNombre());
        report.setVille(reportDto.getVille());
        report.setDatePub(reportDto.getDatePub());

        return report;
    }

    private ReportDto toDto(Report report) {
        ReportDto reportDto = new ReportDto();

        reportDto.setReportID(report.getReportID());
        reportDto.setNom(report.getNom());
        reportDto.setEspece(report.getEspece());
        reportDto.setNombre(report.getNombre());
        reportDto.setVille(report.getVille());
        reportDto.setDatePub(report.getDatePub());

        return reportDto;
    }

    private List<ReportDto> toDtoList(List<Report> reports) {
        List<ReportDto> reportsDto = new ArrayList<>();

        for (Report report : reports) {
            ReportDto currentReportToDto = toDto(report);
            reportsDto.add(currentReportToDto);
        }

        return reportsDto;
    }
}