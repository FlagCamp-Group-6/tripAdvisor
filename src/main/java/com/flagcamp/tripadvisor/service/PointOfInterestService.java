package com.flagcamp.tripadvisor.service;

import com.flagcamp.tripadvisor.exception.PointOfInterestNotExistException;
import com.flagcamp.tripadvisor.model.PointOfInterest;
import com.flagcamp.tripadvisor.repository.PointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PointOfInterestService {
    private final PointOfInterestRepository pointOfInterestRepository;

    @Autowired
    public PointOfInterestService(PointOfInterestRepository pointOfInterestRepository) {
        this.pointOfInterestRepository = pointOfInterestRepository;
    }

    public void add(PointOfInterest pointOfInterest) {
        pointOfInterestRepository.save(pointOfInterest);
    }

    public PointOfInterest findByCurId(Long Id) throws PointOfInterestNotExistException {
        PointOfInterest pointOfInterest = pointOfInterestRepository.findByCurId(Id);
        if (pointOfInterest == null) {
            throw new PointOfInterestNotExistException("There is no Point of Interest with this Id");
        }
        return pointOfInterest;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(Long Id) throws PointOfInterestNotExistException {
        PointOfInterest pointOfInterest = pointOfInterestRepository.findByCurId(Id);
        if (pointOfInterest == null) {
            throw new PointOfInterestNotExistException("There is no Point of Interest with this Id");
        }
        pointOfInterestRepository.deleteById(Id);
    }
}