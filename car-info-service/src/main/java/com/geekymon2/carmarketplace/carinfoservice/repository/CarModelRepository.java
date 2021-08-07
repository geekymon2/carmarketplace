package com.geekymon2.carmarketplace.carinfoservice.repository;

import java.util.List;

import com.geekymon2.carmarketplace.carinfoservice.entities.CarModel;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepository extends ReadOnlyRepository<CarModel, Long> { 
    List<CarModel> findByMakeId(Long makeId);
}
