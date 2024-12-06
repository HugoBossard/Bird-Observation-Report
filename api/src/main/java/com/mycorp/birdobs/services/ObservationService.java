package com.mycorp.birdobs.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycorp.birdobs.dao.ObservationDao;
import com.mycorp.birdobs.dto.ObservationDto;
import com.mycorp.birdobs.models.Observation;

@Service
public class ObservationService {

    @Autowired
    ObservationDao observationDao;

    public ObservationDto save(ObservationDto observationDto) {
        Observation observationReport = toEntity(observationDto);

        Observation savedObservation = observationDao.save(observationReport);

        return toDto(savedObservation);
    }

    public ObservationDto findById(Integer id) {
        Optional<Observation> observationInDb = observationDao.findById(id);

        if (!observationInDb.isPresent()) {
            return null;
        }

        return toDto(observationInDb.get());
    }

    private Observation toEntity(ObservationDto observationDto) {
        Observation observation = new Observation();

        observation.setReportID(observationDto.getReportID());
        observation.setNom(observationDto.getNom());
        observation.setEspece(observationDto.getEspece());
        observation.setNombre(observationDto.getNombre());
        observation.setVille(observationDto.getVille());
        observation.setDatePub(observationDto.getDatePub());

        return observation;
    }

    private ObservationDto toDto(Observation observation) {
        ObservationDto observationDto = new ObservationDto();

        observationDto.setReportID(observation.getReportID());
        observationDto.setNom(observation.getNom());
        observationDto.setEspece(observation.getEspece());
        observationDto.setNombre(observation.getNombre());
        observationDto.setVille(observation.getVille());
        observationDto.setDatePub(observation.getDatePub());

        return observationDto;
    }

    private List<ObservationDto> toDtoList(List<Observation> observations) {
        List<ObservationDto> observationsDto = new ArrayList<>();

        for (Observation observation : observations) {
            ObservationDto currentObservationToDto = toDto(observation);
            observationsDto.add(currentObservationToDto);
        }

        return observationsDto;
    }
}