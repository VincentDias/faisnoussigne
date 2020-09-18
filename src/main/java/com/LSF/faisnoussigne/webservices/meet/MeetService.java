package com.LSF.faisnoussigne.webservices.meet;

import com.LSF.faisnoussigne.webservices.googleGeocode.GoogleGeocodeService;
import com.LSF.faisnoussigne.webservices.googleGeocode.models.GoogleGeocode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetService {

    @Autowired
    MeetRepository repository;

    @Autowired
    GoogleGeocodeService googleGeocodeService;

    public List<Meet> getAll() {
        return repository.findAll();
    }

    public Meet getById(Long id) {
        return repository.findById(id).get();
    }

    public Meet createMeet(Meet meet){
        GoogleGeocode googleReturn = googleGeocodeService.getData(meet.getAddress());
        meet.setAddress(googleReturn.getResults().get(0).getFormattedAddress());
        meet.setLat(googleReturn.getResults().get(0).getGeometry().getLocation().getLat());
        meet.setLng(googleReturn.getResults().get(0).getGeometry().getLocation().getLng());
        return repository.save(meet);
    }

    public Meet updateMeet(Long id, Meet meet) {
        Meet meetToUpdate = repository.findById(id).get();
        GoogleGeocode googleReturn = googleGeocodeService.getData(meet.getAddress());
        meetToUpdate.setTitle(meet.getTitle());
        meetToUpdate.setDate(meet.getDate());
        meetToUpdate.setContent(meet.getContent());
        meetToUpdate.setAddress(googleReturn.getResults().get(0).getFormattedAddress());
        meetToUpdate.setLat(googleReturn.getResults().get(0).getGeometry().getLocation().getLat());
        meetToUpdate.setLng(googleReturn.getResults().get(0).getGeometry().getLocation().getLng());
        return repository.save(meetToUpdate);
    }

    public void deleteMeet(Long id){
        repository.deleteById(id);
    }
}
