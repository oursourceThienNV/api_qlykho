package com.group.samrt.um.respository.uml;

import com.group.samrt.um.domain.uml.ImportWareDetail;
import com.group.samrt.um.domain.uml.WareHouseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImportWareDetailRepository extends JpaRepository<ImportWareDetail,String>, JpaSpecificationExecutor<ImportWareDetail> {
   void deleteAllByImportId(Long id);
   List<ImportWareDetail> findAllByImportId(Long importId);
}
