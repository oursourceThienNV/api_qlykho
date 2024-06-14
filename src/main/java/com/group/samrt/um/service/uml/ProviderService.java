package com.group.samrt.um.service.uml;

import com.group.samrt.um.client.Common.Constant;
import com.group.samrt.um.client.Common.Util.OptimizedPage;

import com.group.samrt.um.client.client.request.ProviderRequest;
import com.group.samrt.um.client.client.request.ProviderRequestSearch;
import com.group.samrt.um.client.client.response.ProviderResponse;

import com.group.samrt.um.client.client.response.uml.ProviderInfoResponse;
import com.group.samrt.um.client.client.response.uml.UserInfoResponse;
import com.group.samrt.um.domain.dto.uml.ProviderDTO;
import com.group.samrt.um.domain.dto.uml.UserDetailDTO;
import com.group.samrt.um.domain.uml.*;
import com.group.samrt.um.respository.uml.AdminUserRepository;
import com.group.samrt.um.respository.uml.ProviderRepository;
import io.github.jhipster.service.QueryService;
import org.hibernate.service.spi.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

@Service
@Transactional(rollbackFor = {Exception.class})
public class ProviderService extends QueryService<Provider> {
    @Autowired
    private AdminUserRepository adminUserRepository;
    @Autowired
    private ProviderRepository providerRepository;

   /* @Transactional(readOnly = false)
    public Boolean approveprovider(providerRequest request) {
        if (request.getId() != null) {
            Optional<provider> provider = this.providerRepository.findById(request.getId());
            provider.get().setStatus(Constant.STATUS_PROJECT.UPLOADED);
            return true;
        }else {
            return false;
        }
    }*/
    @Transactional(readOnly = false)
    public Boolean createProdiver(ProviderRequest request) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AdminUser session = adminUserRepository.findByUsername(userDetails.getUsername());
        if (request.getId() != null) {
            Optional<Provider> provider = this.providerRepository.findById(request.getId());
            if (provider.isPresent()) {
                try {
                    provider.get().setProviderName(request.getProviderName());
                    provider.get().setAddress(request.getAddress());
                    provider.get().setStatus(request.getStatus());
                    provider.get().setEmail(request.getEmail());
                    provider.get().setEmail(request.getPhoneNumber());
                    provider.get().setUpdatedBy(session.getId());
                    provider.get().setUpdatedDt(request.getUpdatedDt());
                    this.providerRepository.save(provider.get());
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
            Provider provider = modelMapper.map(request, Provider.class);
            provider.setCreatedBy(session.getUsername());
            provider.setCreatedDt(Instant.now());
            provider.setProviderName(request.getProviderName());
            provider.setProviderNo(request.getProviderNo());
            provider.setAddress(request.getAddress());
            provider.setStatus(request.getStatus());
            provider.setEmail(request.getEmail());
            provider.setEmail(request.getPhoneNumber());
            provider.setUpdatedBy(session.getId());
            provider.setUpdatedDt(request.getUpdatedDt());
            providerRepository.save(provider);
            return true;
        }catch (Exception e){
            return false;
        }

    // Lay Role tu user
    }
    @Transactional(readOnly = false)
    public ProviderInfoResponse getProviderByNo(ProviderRequest request){
        ProviderInfoResponse response=new ProviderInfoResponse();
        Optional<Provider> provider = providerRepository.findByProviderNoAndStatus(request.getProviderNo(),1L);
        if (provider.isPresent()){
            ProviderDTO item=provider.map(ProviderDTO::new).get();
            response.setProviderDTO(item);
        }else {
            return null;
        }

        return response;
    }
    private String getprovider(){
        return "PR"+String.valueOf(System.currentTimeMillis());
    }
//    @Transactional(readOnly = false)
//    public Boolean deleteUser(QueryBaseRequestById query){
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        AdminUser session = adminUserRepository.findByUsername(userDetails.getUsername());
//        if (!session.getRole().equals(Constant.ROLE_USER.BID)){
//            return false;
//        }
//        Optional<provider> provider = providerRepository.findById(query.getId());
//        this.providerRepository.delete(provider.get());
//        return true;
//    }
    @Transactional(readOnly = true)
    public ProviderResponse pageSearch(ProviderRequestSearch request) throws ServiceException {
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
            Specification<Provider> specification = createSpecification(request);
            Sort sort = Sort.by(Sort.Order.desc("id"));
            Page<ProviderDTO> queryResults = this.providerRepository.findAll(
                    specification, PageRequest.of(request.getPageNumber(), request.getPageSize(), sort)
            ).map(ProviderDTO::new);
            ProviderResponse response = new ProviderResponse();
            response.setPage(OptimizedPage.convert(queryResults));
            return response;
        } catch (Exception e) {
            throw e;
        }
    }
    protected Specification<Provider> createSpecification(ProviderRequestSearch criteria) {

        Specification<Provider> specification = Specification.where(null);
        if(criteria.getProviderNo()!=null){
            specification = specification.and(buildStringSpecification(criteria.getProviderNo(), Provider_.providerNo));
        }
        if(criteria.getProviderName()!=null){
            specification = specification.and(buildStringSpecification(criteria.getProviderName(), Provider_.providerName));
        }
        return specification;
    }

}
