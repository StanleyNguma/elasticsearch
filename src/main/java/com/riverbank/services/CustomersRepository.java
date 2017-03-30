package com.riverbank.services;

/**
 * <p>
 * Created by @StanleyNguma on 29-Mar-17.
 */
import java.util.List;

import com.riverbank.data.Customers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CustomersRepository extends CrudRepository<Customers, Long> {
}
