package com.group.samrt.um.controller.uml;

import com.group.samrt.um.client.Common.Constant;
import com.group.samrt.um.client.client.request.ProductRequest;
import com.group.samrt.um.client.client.request.ProductRequestSearch;
import com.group.samrt.um.client.client.request.ProviderRequest;
import com.group.samrt.um.client.client.request.ProviderRequestSearch;
import com.group.samrt.um.client.client.response.BaseDataResponse;
import com.group.samrt.um.client.client.response.ProductResponse;
import com.group.samrt.um.client.client.response.ProviderResponse;
import com.group.samrt.um.client.client.response.uml.ProviderInfoResponse;
import com.group.samrt.um.service.uml.ProductService;
import com.group.samrt.um.service.uml.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ProviderController {
    @Autowired
    ProviderService providerService;
    @PostMapping("/provider/create-or-update")
    public ResponseEntity<BaseDataResponse<Boolean>> createOrUpdate(@Valid @RequestBody ProviderRequest providerRequest) {
        BaseDataResponse baseDataResponse=new BaseDataResponse();

        Boolean response = null;
        try {
            response = providerService.createProdiver(providerRequest);
            baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
            baseDataResponse.setResponseMessage("Luu Thanh Cong");
            baseDataResponse.setBody(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }

    @PostMapping("/provider/find-by-provider-id")
    public ResponseEntity<BaseDataResponse<ProviderInfoResponse>> getProviderByNo(@Valid @RequestBody ProviderRequest providerRequest) {
        BaseDataResponse baseDataResponse=new BaseDataResponse();

        ProviderInfoResponse response = null;
        try {
            response = providerService.getProviderByNo(providerRequest);
            baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
            baseDataResponse.setResponseMessage("Luu Thanh Cong");
            baseDataResponse.setBody(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
    @PostMapping("/provider/on-search")
    public ResponseEntity<BaseDataResponse<ProviderResponse>> onsearch(@Valid @RequestBody ProviderRequestSearch request){
        BaseDataResponse baseDataResponse = new BaseDataResponse();
        ProviderResponse response=providerService.pageSearch(request);
        baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
        baseDataResponse.setResponseMessage("Detail Student By Class");
        baseDataResponse.setBody(response);
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
}
