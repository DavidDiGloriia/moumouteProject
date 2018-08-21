package com.spring.henallux.moumouteProject.dataAccess.repository;

import com.spring.henallux.moumouteProject.dataAccess.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
@Transactional
public interface PromotionRepository extends JpaRepository<PromotionEntity, Integer>
{
    PromotionEntity findFirstByIdAndStartDateGreaterThanAndEndDateLessThan(Integer id, Date currentDate, Date currentDate2);
}
