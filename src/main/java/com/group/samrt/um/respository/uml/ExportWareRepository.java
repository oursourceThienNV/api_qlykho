package com.group.samrt.um.respository.uml;

import com.group.samrt.um.domain.uml.ExportWare;
import com.group.samrt.um.domain.uml.ImportWare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExportWareRepository extends JpaRepository<ExportWare,String>, JpaSpecificationExecutor<ExportWare> {
   Optional<ExportWare> findById(Long id);
}
