package com.teamresourceful.editorbackend.service;

import com.teamresourceful.editorbackend.beedata.CustomBeeData;
import com.teamresourceful.editorbackend.repository.BeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service Layer
@Service //
public class BeeService {
    private final BeeRepository beeRepository;

    @Autowired
    public BeeService(BeeRepository beeRepository) {
        this.beeRepository = beeRepository;
    }

    public List<CustomBeeData> getBees() {
        return beeRepository.findAll();
    }

    public CustomBeeData getBee(Long id) {
        return beeRepository.findById(id).orElseThrow(() -> new IllegalStateException("Bee with ID " + id + " does not exist!"));
    }

    public void addNewBee(CustomBeeData bee) {
/*        Optional<CustomBeeData> studentOptional = beeRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        beeRepository.save(student);*/
    }

    public void deleteBee(Long beeId) {
        boolean exists = beeRepository.existsById(beeId);
        if(!exists) {
            throw new IllegalStateException("Bee with ID " + beeId + " does not exist!");
        }
        beeRepository.deleteById(beeId);
    }

/*    @Transactional
    public void updateBee(Long beeId, String name, String email) {
        CustomBeeData beeData = beeRepository.findById(beeId).orElseThrow(() -> new IllegalStateException("Bee with ID " + beeId + " does not exist!"));
        if (name != null && name.length() > 0 && !Objects.equals(beeData.getName(), name)) {
            beeData.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(beeData.getEmail(), email)) {
            Optional<CustomBeeData> studentOptional = beeRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email is taken!");
            }
            beeData.setEmail(email);
        }
    }*/
}
