package com.group.samrt.um.respository.uml;

import com.group.samrt.um.domain.uml.ExportWareDetail;
import com.group.samrt.um.domain.uml.ImportWareDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExportWareDetailRepository extends JpaRepository<ExportWareDetail,String>, JpaSpecificationExecutor<ExportWareDetail> {
   void deleteAllByImportId(Long id);
   List<ExportWareDetail> findAllByImportId(Long importId);
}
