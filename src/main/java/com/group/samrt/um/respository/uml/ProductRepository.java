package com.group.samrt.um.respository.uml;

import com.group.samrt.um.domain.uml.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,String>, JpaSpecificationExecutor<Product> {
Optional<Product> findById(Long id);
Optional<Product> findByPnoAndStatus(String pno,Long status);
Optional<Product> findByPno(String pno);
}
