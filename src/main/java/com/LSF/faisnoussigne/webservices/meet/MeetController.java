package com.LSF.faisnoussigne.webservices.meet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meets")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MeetController {

    @Autowired MeetService service;

    @GetMapping()
    public List<Meet> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Meet getSearchById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping()
    public Meet createMeet(@RequestBody Meet meet){
        return service.createMeet(meet);
    }

    @PutMapping()
    public Meet updateMeet(@PathVariable Long id, @RequestBody Meet meet) {
        return service.updateMeet(id, meet);
    }

    @DeleteMapping("{/id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMeet(@PathVariable Long id){
        service.deleteMeet(id);
    }

}
