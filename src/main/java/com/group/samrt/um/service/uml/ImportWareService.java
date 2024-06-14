package com.group.samrt.um.service.uml;

import com.group.samrt.um.client.Common.Constant;
import com.group.samrt.um.client.Common.Util.OptimizedPage;
import com.group.samrt.um.client.client.request.*;
import com.group.samrt.um.client.client.response.ImportInfoResponse;
import com.group.samrt.um.client.client.response.ImportResponse;
import com.group.samrt.um.client.client.response.ProductResponeByWare;
import com.group.samrt.um.client.client.response.ProductResponse;
import com.group.samrt.um.client.client.response.uml.ProductInfoResponse;
import com.group.samrt.um.domain.dto.uml.ImportWareDTO;
import com.group.samrt.um.domain.dto.uml.ImportWareDetailDTO;
import com.group.samrt.um.domain.dto.uml.ProductDTO;
import com.group.samrt.um.domain.dto.uml.ProviderDTO;
import com.group.samrt.um.domain.uml.*;
import com.group.samrt.um.respository.uml.*;
import io.github.jhipster.service.QueryService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = {Exception.class})
public class ImportWareService extends QueryService<ImportWare> {
    @Autowired
    private AdminUserRepository adminUserRepository;
    @Autowired
    private ImportWareRepository importWareRepository;
    @Autowired
    private ImportWareDetailRepository importWareDetailRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private WareHouseRepository wareHouseRepository;
    @Autowired
    private ProviderRepository providerRepository;
    @Transactional(readOnly = false)
    public Boolean createImportWareHouse(ImportWareRequest request) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AdminUser session = adminUserRepository.findByUsername(userDetails.getUsername());
        if (request.getId() != null) {
            Optional<ImportWare> item = this.importWareRepository.findById(request.getId());
            if (item.isPresent()) {
                try {
                    item.get().setCode(request.getCode());
                    item.get().setTitle(request.getTitle());
                    item.get().setDescription(request.getDescription());
                    item.get().setImportDate(request.getImportDate());
                    item.get().setProviderNo(request.getProviderNo());
                    item.get().setUpdatedDt(Instant.now());
                    item.get().setUpdatedBy(session.getId());
                    item.get().setStatus(request.getStatus());
                    this.importWareRepository.save(item.get());
                    this.importWareDetailRepository.deleteAllByImportId(item.get().getId());
                    for(ImportWareDetailDTO importWare : request.getListProducts()){
                        ImportWareDetail wareHouseDetail=new ImportWareDetail();
                        wareHouseDetail.setImportId(item.get().getId());
                        wareHouseDetail.setProductNo(importWare.getProductNo());
                        wareHouseDetail.setAmount(importWare.getAmount());
                        wareHouseDetail.setPrice(importWare.getPrice());
                        wareHouseDetail.setUpdatedBy(session.getId());
                        wareHouseDetail.setCreatedBy(session.getId());
                        wareHouseDetail.setUpdatedDt(Instant.now());
                        wareHouseDetail.setUpdatedDt(Instant.now());
                        this.importWareDetailRepository.save(wareHouseDetail);
                    }
                    if(request.getStatus()==1){
                        for(ImportWareDetailDTO importWareDetailDTO : request.getListProducts()){
                            Optional<Product> product=this.productRepository.findByPno(importWareDetailDTO.getProductNo());
                            product.get().setAmount(product.get().getAmount()+importWareDetailDTO.getAmount());
                            Optional<WareHouse> w=this.wareHouseRepository.findByProductNoAndProviderNo(importWareDetailDTO.getProductNo(), request.getProviderNo());
                            if(w.isPresent()){
                                w.get().setAmount(w.get().getAmount()+importWareDetailDTO.getAmount());
                                w.get().setProductNo(importWareDetailDTO.getProductNo());
                                w.get().setProviderNo(request.getProviderNo());
                                this.wareHouseRepository.save(w.get());
                            }else{
                                WareHouse wnew=new WareHouse();
                                wnew.setAmount(importWareDetailDTO.getAmount());
                                wnew.setProductNo(importWareDetailDTO.getProductNo());
                                wnew.setProviderNo(request.getProviderNo());
                                this.wareHouseRepository.save(wnew);
                            }

                        }
                    }
                    return true;

                }catch (Exception e){
                    return false;
                }
            } else {
                return false;
            }
        }
        try {
            ImportWare importWare=new ImportWare();
            importWare.setCode(getCode());
            importWare.setProviderNo(request.getProviderNo());
            importWare.setTitle(request.getTitle());
            importWare.setStatus(0L);
            importWare.setImportDate(request.getImportDate());
            importWare.setDescription(request.getDescription());
            importWare.setImportDate(request.getImportDate());
            importWare.setUpdatedBy(session.getId());
            importWare.setCreatedBy(session.getId());
            importWare.setUpdatedDt(Instant.now());
            importWare.setUpdatedDt(Instant.now());
            importWare=this.importWareRepository.save(importWare);
            for(ImportWareDetailDTO importWareDetailDTO : request.getListProducts()){
                ImportWareDetail wareHouseDetail=new ImportWareDetail();
                wareHouseDetail.setImportId(importWare.getId());
                wareHouseDetail.setProductNo(importWareDetailDTO.getProductNo());
                wareHouseDetail.setAmount(importWareDetailDTO.getAmount());
                wareHouseDetail.setPrice(importWareDetailDTO.getPrice());
                wareHouseDetail.setUpdatedBy(session.getId());
                wareHouseDetail.setCreatedBy(session.getId());
                wareHouseDetail.setUpdatedDt(Instant.now());
                wareHouseDetail.setUpdatedDt(Instant.now());
                this.importWareDetailRepository.save(wareHouseDetail);
            }
            /*if(importWare.getStatus()==1){
                for(ImportWareDetailDTO importWareDetailDTO : request.getListProducts()){
                    Optional<Product> product=this.productRepository.findByPno(importWareDetailDTO.getProductNo());
                    product.get().setAmount(product.get().getAmount()+importWareDetailDTO.getAmount());
                    Optional<WareHouse> w=this.wareHouseRepository.findByProductNoAndProviderNo(importWareDetailDTO.getProductNo(), request.getProviderNo());
                    if(w.isPresent()){
                        w.get().setAmount(w.get().getAmount()+importWareDetailDTO.getAmount());
                        w.get().setProductNo(importWareDetailDTO.getProductNo());
                        w.get().setProviderNo(request.getProviderNo());
                        this.wareHouseRepository.save(w.get());
                    }else{
                        WareHouse wnew=new WareHouse();
                        wnew.setAmount(importWareDetailDTO.getAmount());
                        wnew.setProductNo(importWareDetailDTO.getProductNo());
                        wnew.setProviderNo(request.getProviderNo());
                        this.wareHouseRepository.save(wnew);
                    }

                }
            }*/
            return true;
        }catch (Exception e){
            return false;
        }

        // Lay Role tu user
    }
    private String getCode(){
        return "NK"+String.valueOf(System.currentTimeMillis());
    }
    @Transactional(readOnly = true)
    public ImportResponse pageSearch(ImportRequestSearch request) throws ServiceException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AdminUser user = adminUserRepository.findByUsername(userDetails.getUsername());
        if(user==null)
            return null;


        try {
            if (request == null)
                return null;

            if (request.getPageNumber() < Constant.PAGE.PAGE_NUMBER)
                request.setPageNumber(Constant.PAGE.PAGE_NUMBER);

            if (request.getPageSize() < 1)
                request.setPageSize(Constant.PAGE.PAGE_SIZE);
            Specification<ImportWare> specification = createSpecification(request);
            Sort sort = Sort.by(Sort.Order.desc("id"));
            Page<ImportWareDTO> queryResults = this.importWareRepository.findAll(
                    specification, PageRequest.of(request.getPageNumber(), request.getPageSize(), sort)
            ).map(ImportWareDTO::new);
            ImportResponse response = new ImportResponse();
            response.setPage(OptimizedPage.convert(queryResults));
            return response;
        } catch (Exception e) {
            throw e;
        }
    }
    protected Specification<ImportWare> createSpecification(ImportRequestSearch criteria) {

        Specification<ImportWare> specification = Specification.where(null);
        if(criteria.getCode()!=null){
            specification = specification.and(buildStringSpecification(criteria.getCode(), ImportWare_.code));
        }
        if(criteria.getTitle()!=null){
            specification = specification.and(buildStringSpecification(criteria.getTitle(), ImportWare_.title));
        }
        return specification;
    }
    @Transactional(readOnly = false)
    public ImportInfoResponse getByImportId(QueryBaseRequestById request){
        ImportInfoResponse response=new ImportInfoResponse();
        Optional<ImportWare> item = importWareRepository.findById(request.getId());
        if (item.isPresent()){
            ImportWareDTO importWareDTO=item.map(ImportWareDTO::new).get();
            response.setImportWare(importWareDTO);
            Optional<Provider> provider=providerRepository.findByProviderNo(importWareDTO.getProviderNo());
            ProviderDTO providerDTO=provider.map(ProviderDTO::new).get();
            response.setProvider(providerDTO);
            List<ImportWareDetail> list=this.importWareDetailRepository.findAllByImportId(request.getId());
            List<ProductResponeByWare> lts=new ArrayList<>();
            for(ImportWareDetail itemI: list){
                ProductResponeByWare productDTO=new ProductResponeByWare();
                productDTO.setAmount(itemI.getAmount());
                productDTO.setPrice(itemI.getPrice());
                Optional<Product> product=this.productRepository.findByPno(itemI.getProductNo());
                productDTO.setProductName(product.get().getPname());
                productDTO.setProductNo(product.get().getPno());
                lts.add(productDTO);
            }
            response.setListProducts(lts);
        }else {
            return null;
        }

        return response;
    }
}
