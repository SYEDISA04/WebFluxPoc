package com.Poc.WebFluxPoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceEmp {

    @Autowired
    private EmpRepo emprepo;

    public Mono<EmpModel> getEmployeebyId(String id){
    return emprepo.findById(id);
    }

    public Flux<EmpModel> getAllEmployee(){
        return emprepo.findAll();
    }

    public Mono<EmpModel> Save(EmpModel empmodel){
    return emprepo.save(empmodel);
    }

    public Mono<Void> deleteById(String id){
        return emprepo.deleteById(id);
    }
    public Mono<EmpModel> updateEmp(String id , EmpModel empmodel){
        return emprepo.findById(id)
                .flatMap(extemp->{
                    extemp.setName(empmodel.getName());
                    extemp.setDesignation(empmodel.getDesignation());
                    extemp.setSalary(empmodel.getSalary());
                    extemp.setDesignation(empmodel.getDesignation());
                    return emprepo.save(extemp);
                })
                .switchIfEmpty(Mono.empty());
    }
}
