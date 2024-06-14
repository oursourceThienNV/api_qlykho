package com.group.samrt.um.service.uml;

import com.group.samrt.um.client.Common.Constant;
import com.group.samrt.um.client.Common.Util.OptimizedPage;
import com.group.samrt.um.client.client.request.ProductRequest;
import com.group.samrt.um.client.client.request.ProductRequestSearch;

import com.group.samrt.um.client.client.request.ProviderRequest;
import com.group.samrt.um.client.client.response.ProductResponse;
import com.group.samrt.um.client.client.response.uml.ProductInfoResponse;
import com.group.samrt.um.client.client.response.uml.ProviderInfoResponse;
import com.group.samrt.um.domain.dto.uml.ProductDTO;
import com.group.samrt.um.domain.dto.uml.ProviderDTO;
import com.group.samrt.um.domain.uml.AdminUser;
import com.group.samrt.um.domain.uml.Product;
import com.group.samrt.um.domain.uml.Product_;
import com.group.samrt.um.domain.uml.Provider;
import com.group.samrt.um.respository.uml.AdminUserRepository;
import com.group.samrt.um.respository.uml.ProductRepository;
import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.StringFilter;
import org.hibernate.service.spi.ServiceException;
import org.modelmapper.ModelMapper;
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
public class ProductService extends QueryService<Product> {
    @Autowired
    private AdminUserRepository adminUserRepository;
    @Autowired
    private ProductRepository productRepository;

   /* @Transactional(readOnly = false)
    public Boolean approveProduct(ProductRequest request) {
        if (request.getId() != null) {
            Optional<Product> product = this.productRepository.findById(request.getId());
            product.get().setStatus(Constant.STATUS_PROJECT.UPLOADED);
            return true;
        }else {
            return false;
        }
    }*/
    @Transactional(readOnly = false)
    public Boolean createProduct(ProductRequest request) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AdminUser session = adminUserRepository.findByUsername(userDetails.getUsername());
        if (request.getId() != null) {
            Optional<Product> product = this.productRepository.findById(request.getId());
            if (product.isPresent()) {
                try {
                    product.get().setPname(request.getPname());
                    product.get().setDescription(request.getDescription());
                    product.get().setUpdatedBy(session.getId());
                    product.get().setUpdatedDt(request.getUpdatedDt());
                    this.productRepository.save(product.get());
                    return true;
                }catch (Exception e){
                    return false;
                }
            } else {
                return false;
            }
        }
        try {
            ModelMapper modelMapper = new ModelMapper();
            Product product = modelMapper.map(request, Product.class);
            product.setCreatedBy(session.getUsername());
            product.setCreatedDt(Instant.now());
            product.setUpdatedBy(session.getId());
            product.setUpdatedDt(Instant.now());
            product.setStatus(1L);
            product.setAmount(0L);
            product.setPno(getProduct());
            productRepository.save(product);
            return true;
        }catch (Exception e){
            return false;
        }

    // Lay Role tu user
    }
    private String getProduct(){
        return "PR"+String.valueOf(System.currentTimeMillis());
    }
//    @Transactional(readOnly = false)
//    public Boolean deleteUser(QueryBaseRequestById query){
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        AdminUser session = adminUserRepository.findByUsername(userDetails.getUsername());
//        if (!session.getRole().equals(Constant.ROLE_USER.BID)){
//            return false;
//        }
//        Optional<Product> product = productRepository.findById(query.getId());
//        this.productRepository.delete(product.get());
//        return true;
//    }
    @Transactional(readOnly = true)
    public ProductResponse pageSearch(ProductRequestSearch request) throws ServiceException {
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
            Specification<Product> specification = createSpecification(request);
            Sort sort = Sort.by(Sort.Order.desc("id"));
            Page<ProductDTO> queryResults = this.productRepository.findAll(
                    specification, PageRequest.of(request.getPageNumber(), request.getPageSize(), sort)
            ).map(ProductDTO::new);
            ProductResponse response = new ProductResponse();
            response.setPage(OptimizedPage.convert(queryResults));
            return response;
        } catch (Exception e) {
            throw e;
        }
    }
    protected Specification<Product> createSpecification(ProductRequestSearch criteria) {

        Specification<Product> specification = Specification.where(null);
        if(criteria.getPno()!=null){
            specification = specification.and(buildStringSpecification(criteria.getPno(), Product_.pno));
        }
        if(criteria.getPname()!=null){
            specification = specification.and(buildStringSpecification(criteria.getPname(), Product_.pname));
        }
        return specification;
    }
    @Transactional(readOnly = false)
    public ProductInfoResponse getProductByPno(ProductRequest request){
        ProductInfoResponse response=new ProductInfoResponse();
        Optional<Product> provider = productRepository.findByPnoAndStatus(request.getPno(),1L);
        if (provider.isPresent()){
            ProductDTO item=provider.map(ProductDTO::new).get();
            response.setProductDTO(item);
        }else {
            return null;
        }

        return response;
    }
}
