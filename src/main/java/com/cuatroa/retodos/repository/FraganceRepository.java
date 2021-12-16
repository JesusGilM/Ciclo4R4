package com.cuatroa.retodos.repository;

import com.cuatroa.retodos.model.Fragance;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cuatroa.retodos.repository.crud.FraganceCrudRepository;

/**
 *
 * @author JGil Version 1
 */
@Repository
public class FraganceRepository {
    @Autowired
    private FraganceCrudRepository repository;

    public List<Fragance> getAll() {
        return repository.findAll();
    }

    public Optional<Fragance> getClothe(String reference) {
        return repository.findById(reference);
    }
    
    public Fragance create(Fragance clothe) {
        return repository.save(clothe);
    }

    public void update(Fragance clothe) {
        repository.save(clothe);
    }
    
    public void delete(Fragance clothe) {
        repository.delete(clothe);
    }
    
    public List<Fragance> productByPrice(double precio) {
	return repository.findByPriceLessThanEqual(precio);
}
}
