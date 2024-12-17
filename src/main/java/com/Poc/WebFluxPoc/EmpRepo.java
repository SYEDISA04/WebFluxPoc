package com.Poc.WebFluxPoc;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends ReactiveMongoRepository<EmpModel, String> {

}
