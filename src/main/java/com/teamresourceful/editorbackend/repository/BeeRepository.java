package com.teamresourceful.editorbackend.repository;

import com.teamresourceful.editorbackend.model.beedata.BeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BeeRepository extends JpaRepository<BeeData, Long> {

/*    @Query("SELECT b FROM CustomBeeData b WHERE b.email = ?1")
    Optional<CustomBeeData> findStudentByEmail(String email);*/

    @Query("SELECT b FROM Bee_Data b WHERE b.id = ?1")
    Optional<BeeData> findById(UUID id);
}
