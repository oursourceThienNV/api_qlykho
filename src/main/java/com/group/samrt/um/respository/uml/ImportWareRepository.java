package com.group.samrt.um.respository.uml;

import com.group.samrt.um.domain.uml.ImportWare;
import com.group.samrt.um.domain.uml.WareHouse;
import com.group.samrt.um.domain.uml.WareHouseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImportWareRepository extends JpaRepository<ImportWare,String>, JpaSpecificationExecutor<ImportWare> {
   Optional<ImportWare> findById(Long id);
}
