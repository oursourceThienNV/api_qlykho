package com.group.samrt.um.respository.uml;

import com.group.samrt.um.domain.uml.Product;
import com.group.samrt.um.domain.uml.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProviderRepository extends JpaRepository<Provider,String>, JpaSpecificationExecutor<Provider> {
Optional<Provider> findById(Long id);
Optional<Provider> findByProviderNo(String providerNo);
Optional<Provider> findByProviderNoAndStatus(String providerNo,Long status);
}
