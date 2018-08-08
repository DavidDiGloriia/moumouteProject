package com.spring.henallux.moumouteProject.dataAccess.repository;

import com.spring.henallux.moumouteProject.dataAccess.entity.ColorTradEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface ColorTradRepository extends JpaRepository<ColorTradEntity, Integer>
{
}
