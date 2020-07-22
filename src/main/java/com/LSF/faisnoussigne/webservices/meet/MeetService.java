package com.LSF.faisnoussigne.webservices.meet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetService {

    @Autowired
    MeetRepository repository;

    public List<Meet> getAll() {
        return repository.findAll();
    }

    public Meet getById(Long id) {
        return repository.findById(id).get();
    }

    public Meet createMeet(Meet meet){
        return repository.save(meet);
    }

    public Meet updateMeet(Long id, Meet meet) {
        Meet meetToUpdate = repository.findById(id).get();
        meetToUpdate.setTitle(meet.getTitle());
        meetToUpdate.setDate(meet.getDate());
        meetToUpdate.setAdress(meet.getAdress());
        meetToUpdate.setLatitude(meet.getLatitude());
        meetToUpdate.setLongitude(meet.getLongitude());

        return repository.save(meetToUpdate);
    }

    public void deleteMeet(Long id){
        repository.deleteById(id);
    }
}
