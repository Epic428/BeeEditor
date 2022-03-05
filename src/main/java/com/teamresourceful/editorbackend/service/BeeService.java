package com.teamresourceful.editorbackend.service;

import com.teamresourceful.editorbackend.model.beedata.BeeData;
import com.teamresourceful.editorbackend.repository.BeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

//Service Layer
@Service //
public class BeeService {
    private final BeeRepository beeRepository;

    @Autowired
    public BeeService(BeeRepository beeRepository) {
        this.beeRepository = beeRepository;
    }

    public List<BeeData> getBees() {
        return beeRepository.findAll();
    }

    public BeeData getBee(UUID id) {
        return beeRepository.findById(id).orElseThrow(() -> new IllegalStateException("Bee with ID " + id + " does not exist!"));
    }

    public BeeData addNewBee(BeeData bee) {
        bee.getCoreData().setBeeData(bee);
        bee.getRenderData().setBeeData(bee);
        return beeRepository.save(bee);
    }

    public void deleteBee(Long beeId) {
        if (!beeRepository.existsById(beeId)) {
            throw new IllegalStateException("Bee with ID " + beeId + " does not exist!");
        }
        beeRepository.deleteById(beeId);
    }

    public static BeeData update(Long bee_id, BeeData beeData) {
        return beeData;
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
