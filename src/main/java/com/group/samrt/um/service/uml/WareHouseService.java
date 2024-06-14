//package com.group.samrt.um.service.uml;
//
//import com.group.samrt.um.client.client.request.WareHouseRequest;
//import com.group.samrt.um.domain.dto.uml.WareHouseDetailDTO;
//import com.group.samrt.um.domain.uml.AdminUser;
//import com.group.samrt.um.domain.uml.WareHouse;
//import com.group.samrt.um.domain.uml.WareHouseDetail;
//import com.group.samrt.um.respository.uml.AdminUserRepository;
//import com.group.samrt.um.respository.uml.ImportWareRepository;
//import com.group.samrt.um.respository.uml.WareHouseRepository;
//import io.github.jhipster.service.QueryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.Instant;
//import java.util.Optional;
//
//@Service
//@Transactional(rollbackFor = {Exception.class})
//public class WareHouseService extends QueryService<WareHouse> {
//    @Autowired
//    private AdminUserRepository adminUserRepository;
//    @Autowired
//    private WareHouseRepository wareHouseRepository;
//    @Autowired
//    private ImportWareRepository wareHouseDetailRepository;
//    @Transactional(readOnly = false)
//    public Boolean createWareHouse(WareHouseRequest request) {
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        AdminUser session = adminUserRepository.findByUsername(userDetails.getUsername());
//        if (request.getId() != null) {
//            Optional<WareHouse> wareHouse = this.wareHouseRepository.findById(request.getId());
//            if (wareHouse.isPresent()) {
//                try {
//                    wareHouse.get().setCode(request.getCode());
//                    wareHouse.get().setTitle(request.getTitle());
//                    wareHouse.get().setStatus(request.getStatus());
//                    wareHouse.get().setDescription(request.getDescription());
//                    wareHouse.get().setImportDate(request.getImportDate());
//                    wareHouse.get().setUpdatedBy(session.getId());
//                    wareHouse.get().setUpdatedDt(request.getUpdatedDt());
//                    this.wareHouseRepository.save(wareHouse.get());
//                    this.wareHouseDetailRepository.deleteAllById(wareHouse.get().getId());
//                    for(WareHouseDetailDTO wareHouseDetailDTO:request.getListWarHourseDetail()){
//                        WareHouseDetail wareHouseDetail=new WareHouseDetail();
//                        wareHouseDetail.setWareId(wareHouse.get().getId());
//                        wareHouseDetail.setProductId(wareHouseDetailDTO.getProductId());
//                        wareHouseDetail.setProviderId(wareHouseDetailDTO.getProviderId());
//                        wareHouseDetail.setAmount(wareHouseDetailDTO.getAmount());
//                        wareHouseDetail.setPrice(wareHouseDetailDTO.getPrice());
//                        this.wareHouseDetailRepository.save(wareHouseDetail);
//                    }
//                    return true;
//
//                }catch (Exception e){
//                    return false;
//                }
//            } else {
//                return false;
//            }
//        }
//        try {
//            WareHouse wareHouse=new WareHouse();
//            wareHouse.setCode(request.getCode());
//            wareHouse.setTitle(request.getTitle());
//            wareHouse.setStatus(request.getStatus());
//            wareHouse.setDescription(request.getDescription());
//            wareHouse.setImportDate(request.getImportDate());
//            wareHouse.setUpdatedBy(session.getId());
//            wareHouse.setCreatedBy(session.getId());
//            wareHouse.setUpdatedDt(Instant.now());
//            wareHouse.setUpdatedDt(Instant.now());
//            this.wareHouseRepository.save(wareHouse);
//            for(WareHouseDetailDTO wareHouseDetailDTO:request.getListWarHourseDetail()){
//                WareHouseDetail wareHouseDetail=new WareHouseDetail();
//                wareHouseDetail.setWareId(wareHouse.getId());
//                wareHouseDetail.setProductId(wareHouseDetailDTO.getProductId());
//                wareHouseDetail.setProductId(wareHouseDetailDTO.getProductId());
//                wareHouseDetail.setAmount(wareHouseDetailDTO.getAmount());
//                wareHouseDetail.setPrice(wareHouseDetailDTO.getPrice());
//                this.wareHouseDetailRepository.save(wareHouseDetail);
//            }
//            return true;
//        }catch (Exception e){
//            return false;
//        }
//
//        // Lay Role tu user
//    }
//}
