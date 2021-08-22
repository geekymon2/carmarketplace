package com.geekymon2.carmarketplace.carinfoservice.repository;

import java.util.List;

import com.geekymon2.carmarketplace.carinfoservice.entities.CarModel;

import com.geekymon2.carmarketplace.carinfoservice.entities.CarModelType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepository extends ReadOnlyRepository<CarModel, Long> { 
    List<CarModel> findByMakeId(Long makeId);

    @Query("SELECT m FROM model m WHERE (:makeId is null or m.make.id = :makeId) and (:type is null"
            + " or m.type = :type)")
    List<CarModel> findByMakeIdAndType(@Param("makeId") Long makeId, @Param("type") CarModelType type);
}
