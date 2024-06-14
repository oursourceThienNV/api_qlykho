package com.group.samrt.um.controller.uml;

import com.group.samrt.um.client.Common.Constant;
import com.group.samrt.um.client.client.request.ProductRequest;
import com.group.samrt.um.client.client.request.ProductRequestSearch;
import com.group.samrt.um.client.client.request.ProviderRequest;
import com.group.samrt.um.client.client.request.uml.UserRegisterRequest;
import com.group.samrt.um.client.client.response.BaseDataResponse;
import com.group.samrt.um.client.client.response.ProductResponse;
import com.group.samrt.um.client.client.response.uml.ProductInfoResponse;
import com.group.samrt.um.client.client.response.uml.ProviderInfoResponse;
import com.group.samrt.um.service.uml.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/product/create-or-update")
    public ResponseEntity<BaseDataResponse<Boolean>> createOrUpdate(@Valid @RequestBody ProductRequest productRequest) {
        BaseDataResponse baseDataResponse=new BaseDataResponse();

        Boolean response = null;
        try {
            response = productService.createProduct(productRequest);
            baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
            baseDataResponse.setResponseMessage("Luu Thanh Cong");
            baseDataResponse.setBody(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
    @PostMapping("/product/on-search")
    public ResponseEntity<BaseDataResponse<ProductResponse>> onsearch(@Valid @RequestBody ProductRequestSearch request){
        BaseDataResponse baseDataResponse = new BaseDataResponse();
        ProductResponse response=productService.pageSearch(request);
        baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
        baseDataResponse.setResponseMessage("Detail Student By Class");
        baseDataResponse.setBody(response);
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
    @PostMapping("/product/find-by-product-id")
    public ResponseEntity<BaseDataResponse<ProductInfoResponse>> getProviderByNo(@Valid @RequestBody ProductRequest productRequest) {
        BaseDataResponse baseDataResponse=new BaseDataResponse();

        ProductInfoResponse response = null;
        try {
            response = productService.getProductByPno(productRequest);
            baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
            baseDataResponse.setResponseMessage("Thành công");
            baseDataResponse.setBody(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
}
