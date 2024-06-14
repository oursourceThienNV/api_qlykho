package com.group.samrt.um.service.uml;

import com.group.samrt.um.client.Common.Constant;
import com.group.samrt.um.client.Common.Util.OptimizedPage;
import com.group.samrt.um.client.client.request.*;
import com.group.samrt.um.client.client.response.ExportInfoResponse;
import com.group.samrt.um.client.client.response.ExportResponse;
import com.group.samrt.um.client.client.response.ImportInfoResponse;
import com.group.samrt.um.client.client.response.ProductResponeByWare;
import com.group.samrt.um.domain.dto.uml.*;
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
public class ExportWareService extends QueryService<ExportWare> {
    @Autowired
    private AdminUserRepository adminUserRepository;
    @Autowired
    private ExportWareRepository exportWareRepository;
    @Autowired
    private ExportWareDetailRepository exportWareDetailRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private WareHouseRepository wareHouseRepository;
    @Autowired
    private ProviderRepository providerRepository;
    @Transactional(readOnly = false)
    public Boolean createImportWareHouse(ExportWareRequest request) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AdminUser session = adminUserRepository.findByUsername(userDetails.getUsername());
        if (request.getId() != null) {
            Optional<ExportWare> item = this.exportWareRepository.findById(request.getId());
            if (item.isPresent()) {
                try {
                    item.get().setCode(request.getCode());
                    item.get().setTitle(request.getTitle());
                    item.get().setDescription(request.getDescription());
                    item.get().setImportDate(request.getImportDate());
                    item.get().setUpdatedDt(Instant.now());
                    item.get().setUpdatedBy(session.getId());
                    item.get().setStatus(request.getStatus());
                    this.exportWareRepository.save(item.get());
                    this.exportWareDetailRepository.deleteAllByImportId(item.get().getId());
                    for(ExportWareDetailDTO importWare : request.getListProducts()){
                        ExportWareDetail wareHouseDetail=new ExportWareDetail();
                        wareHouseDetail.setImportId(item.get().getId());
                        wareHouseDetail.setProductNo(importWare.getProductNo());
                        wareHouseDetail.setProviderNo(importWare.getProviderNo());
                        wareHouseDetail.setAmount(importWare.getAmount());
                        wareHouseDetail.setPrice(importWare.getPrice());
                        wareHouseDetail.setUpdatedBy(session.getId());
                        wareHouseDetail.setCreatedBy(session.getId());
                        wareHouseDetail.setUpdatedDt(Instant.now());
                        wareHouseDetail.setUpdatedDt(Instant.now());
                        this.exportWareDetailRepository.save(wareHouseDetail);
                    }
                    if(request.getStatus()==1){
                        for(ExportWareDetailDTO importWareDetailDTO : request.getListProducts()){
                            Optional<Product> product=this.productRepository.findByPno(importWareDetailDTO.getProductNo());
                            product.get().setAmount(product.get().getAmount()-importWareDetailDTO.getAmount());
                            Optional<WareHouse> w=this.wareHouseRepository.findByProductNoAndProviderNo(importWareDetailDTO.getProductNo(), importWareDetailDTO.getProviderNo());
                            if(w.isPresent()){
                                w.get().setAmount(w.get().getAmount()-importWareDetailDTO.getAmount());
                                this.wareHouseRepository.save(w.get());
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
            ExportWare importWare=new ExportWare();
            importWare.setCode(getCode());
            importWare.setTitle(request.getTitle());
            importWare.setStatus(0L);
            importWare.setImportDate(request.getImportDate());
            importWare.setDescription(request.getDescription());
            importWare.setImportDate(request.getImportDate());
            importWare.setUpdatedBy(session.getId());
            importWare.setCreatedBy(session.getId());
            importWare.setUpdatedDt(Instant.now());
            importWare.setUpdatedDt(Instant.now());
            importWare=this.exportWareRepository.save(importWare);
            for(ExportWareDetailDTO importWareDetailDTO : request.getListProducts()){
                ExportWareDetail wareHouseDetail=new ExportWareDetail();
                wareHouseDetail.setImportId(importWare.getId());
                wareHouseDetail.setProductNo(importWareDetailDTO.getProductNo());
                wareHouseDetail.setProviderNo(importWareDetailDTO.getProviderNo());
                wareHouseDetail.setAmount(importWareDetailDTO.getAmount());
                wareHouseDetail.setPrice(importWareDetailDTO.getPrice());
                wareHouseDetail.setUpdatedBy(session.getId());
                wareHouseDetail.setCreatedBy(session.getId());
                wareHouseDetail.setUpdatedDt(Instant.now());
                wareHouseDetail.setUpdatedDt(Instant.now());
                this.exportWareDetailRepository.save(wareHouseDetail);
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
    public ExportResponse pageSearch(ImportRequestSearch request) throws ServiceException {
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
            Specification<ExportWare> specification = createSpecification(request);
            Sort sort = Sort.by(Sort.Order.desc("id"));
            Page<ExportWareDTO> queryResults = this.exportWareRepository.findAll(
                    specification, PageRequest.of(request.getPageNumber(), request.getPageSize(), sort)
            ).map(ExportWareDTO::new);
            ExportResponse response = new ExportResponse();
            response.setPage(OptimizedPage.convert(queryResults));
            return response;
        } catch (Exception e) {
            throw e;
        }
    }
    @Transactional(readOnly = false)
    public ExportInfoResponse getByImportId(QueryBaseRequestById request){
        ExportInfoResponse response=new ExportInfoResponse();
        Optional<ExportWare> item = exportWareRepository.findById(request.getId());
        if (item.isPresent()){
            ExportWareDTO exportWareDTO=item.map(ExportWareDTO::new).get();
            response.setExportWareDTO(exportWareDTO);
            List<ExportWareDetail> list=this.exportWareDetailRepository.findAllByImportId(request.getId());
            List<ProductResponeByWare> lts=new ArrayList<>();
            for(ExportWareDetail itemI: list){
                ProductResponeByWare productDTO=new ProductResponeByWare();
                productDTO.setAmount(itemI.getAmount());
                productDTO.setPrice(itemI.getPrice());
                Optional<Product> product=this.productRepository.findByPno(itemI.getProductNo());
                productDTO.setProductName(product.get().getPname());
                productDTO.setProductNo(product.get().getPno());
                Optional<Provider>provider=this.providerRepository.findByProviderNo(itemI.getProviderNo());
                productDTO.setProviderNo(provider.get().getProviderNo());
                productDTO.setProductName(provider.get().getProviderName());
                lts.add(productDTO);
            }
            response.setListProducts(lts);
        }else {
            return null;
        }

        return response;
    }
    protected Specification<ExportWare> createSpecification(ImportRequestSearch criteria) {

        Specification<ExportWare> specification = Specification.where(null);
        if(criteria.getCode()!=null){
            specification = specification.and(buildStringSpecification(criteria.getCode(), ExportWare_.code));
        }
        if(criteria.getTitle()!=null){
            specification = specification.and(buildStringSpecification(criteria.getTitle(), ExportWare_.title));
        }
        return specification;
    }
//    @Transactional(readOnly = false)
//    public ImportInfoResponse getByImportId(QueryBaseRequestById request){
//        ImportInfoResponse response=new ImportInfoResponse();
//        Optional<ImportWare> item = importWareRepository.findById(request.getId());
//        if (item.isPresent()){
//            ImportWareDTO importWareDTO=item.map(ImportWareDTO::new).get();
//            response.setImportWare(importWareDTO);
//            Optional<Provider> provider=providerRepository.findByProviderNo(importWareDTO.getProviderNo());
//            ProviderDTO providerDTO=provider.map(ProviderDTO::new).get();
//            response.setProvider(providerDTO);
//            List<ImportWareDetail> list=this.importWareDetailRepository.findAllByImportId(request.getId());
//            List<ProductResponeByWare> lts=new ArrayList<>();
//            for(ImportWareDetail itemI: list){
//                ProductResponeByWare productDTO=new ProductResponeByWare();
//                productDTO.setAmount(itemI.getAmount());
//                productDTO.setPrice(itemI.getPrice());
//                Optional<Product> product=this.productRepository.findByPno(itemI.getProductNo());
//                productDTO.setProductName(product.get().getPname());
//                productDTO.setProductNo(product.get().getPno());
//                lts.add(productDTO);
//            }
//            response.setListProducts(lts);
//        }else {
//            return null;
//        }
//
//        return response;
//    }*/
    @Transactional(readOnly = false)
    public ListProviderInfoResponse getByProductNo(ProductNoRequest request){
        List<WareHouse> wareHouseList=this.wareHouseRepository.findAllByProductNo(request.getProductNo());
        Optional<Product> product=this.productRepository.findByPno(request.getProductNo());
        ProductDTO productDTO=product.map(ProductDTO::new).get();
        List<ProviderDTO> lts=new ArrayList<>();
        for(WareHouse item:wareHouseList){
            Optional<Provider> provider=this.providerRepository.findByProviderNo(item.getProviderNo());
            ProviderDTO providerDTO=provider.map(ProviderDTO::new).get();
            lts.add(providerDTO);
        }
        ListProviderInfoResponse response=new ListProviderInfoResponse();
        response.setListProviders(lts);
        response.setProductDTO(productDTO);
        return response;
    }
}
