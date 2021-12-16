package com.cuatroa.retodos.service;

import com.cuatroa.retodos.model.Fragance;
import com.cuatroa.retodos.repository.FraganceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author JGil Version 1
 */
@Service
public class FraganceService {

    @Autowired
    private FraganceRepository repository;

    public List<Fragance> getAll() {
        return repository.getAll();
    }

    public Optional<Fragance> getClothe(String reference) {
        return repository.getClothe(reference);
    }

    public Fragance create(Fragance accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return repository.create(accesory);
        }
    }

    public Fragance update(Fragance accesory) {

        if (accesory.getReference() != null) {
            Optional<Fragance> accesoryDb = repository.getClothe(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                if (accesory.getBrand() != null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getPresentation() != null) {
                    accesoryDb.get().setPresentation(accesory.getPresentation());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                repository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            repository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Fragance> productByPrice(double price) {
        return repository.productByPrice(price);
    }

}
