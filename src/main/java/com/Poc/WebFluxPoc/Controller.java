package com.Poc.WebFluxPoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController

public class Controller {

    @Autowired
    private ServiceEmp serviceemp;

    @GetMapping("employee")
    public Flux<EmpModel> getAll(){
        return serviceemp.getAllEmployee();
    }
    @GetMapping("employee/{id}")
    public Mono<EmpModel> getById(@PathVariable String id){
        return serviceemp.getEmployeebyId(id);
    }

    @PutMapping("upd/{id}")
    public Mono<EmpModel> Upd(@PathVariable String id, @RequestBody EmpModel empmodel){
        return serviceemp.updateEmp(id,empmodel);
    }
    @DeleteMapping("dlt/{id}")
    public Mono<Void> dlt(@PathVariable String id){
        return serviceemp.deleteById(id);
    }

    @PostMapping("/crt")
    public Mono<EmpModel> createUser(@RequestBody EmpModel empmodel){
        return serviceemp.Save(empmodel);
    }
}
