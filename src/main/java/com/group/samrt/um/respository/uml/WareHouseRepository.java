package com.group.samrt.um.respository.uml;

import com.group.samrt.um.domain.uml.Provider;
import com.group.samrt.um.domain.uml.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WareHouseRepository extends JpaRepository<WareHouse,String>, JpaSpecificationExecutor<WareHouse> {
   Optional<WareHouse> findById(Long id);
   List<WareHouse> findAllByProductNo(String productNo);
   Optional<WareHouse> findByProductNoAndProviderNo(String productNo,String providerNo);
}
