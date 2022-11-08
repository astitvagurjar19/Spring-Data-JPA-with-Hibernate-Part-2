package com.tothenew.JPAandNativeSql.repos;

import com.tothenew.JPAandNativeSql.entities.Payments;
import org.springframework.data.repository.CrudRepository;

public interface PaymentsRepository extends CrudRepository<Payments,Integer> {
}
