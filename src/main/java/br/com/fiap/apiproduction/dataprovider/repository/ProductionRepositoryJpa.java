package br.com.fiap.apiproduction.dataprovider.repository;

import br.com.fiap.apiproduction.dataprovider.repository.entity.ProductionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionRepositoryJpa extends MongoRepository<ProductionEntity, String> {


}
