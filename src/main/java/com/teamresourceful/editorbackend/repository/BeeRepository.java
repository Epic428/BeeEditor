package com.teamresourceful.editorbackend.repository;

import com.teamresourceful.editorbackend.beedata.CustomBeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeeRepository extends JpaRepository<CustomBeeData, Long> {

/*    @Query("SELECT b FROM CustomBeeData b WHERE b.email = ?1")
    Optional<CustomBeeData> findStudentByEmail(String email);*/
}
