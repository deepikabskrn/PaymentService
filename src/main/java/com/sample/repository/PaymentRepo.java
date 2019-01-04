package com.sample.repository;

import com.sample.business.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PaymentRepo extends MongoRepository<Payment,String	> {

}
