/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuatroa.retodos.repository.crud;

import com.cuatroa.retodos.model.Fragance;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author JGil Version 1
 */
public interface FraganceCrudRepository extends MongoRepository<Fragance, String> {
    public List<Fragance> findByPriceLessThanEqual(double precio);
}
