package com.spring.henallux.moumouteProject.dataAccess.repository;


import com.spring.henallux.moumouteProject.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, String>
{
    public UserEntity findByUsername(String username);
    public UserEntity findByEmail(String email);
}
