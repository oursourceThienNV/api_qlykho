package com.group.samrt.um.controller.uml;

import com.group.samrt.um.client.Common.Constant;
import com.group.samrt.um.client.client.request.*;
import com.group.samrt.um.client.client.response.*;
import com.group.samrt.um.domain.uml.ExportWare;
import com.group.samrt.um.domain.uml.ImportWare;
import com.group.samrt.um.service.uml.ExportWareService;
import com.group.samrt.um.service.uml.ImportWareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ExportImportProductController {
    @Autowired
    ImportWareService importWareService;
    @Autowired
    ExportWareService exportWareService;
    @PostMapping("/import/create-or-update")
    public ResponseEntity<BaseDataResponse<Boolean>> createOrUpdate(@Valid @RequestBody ImportWareRequest request) {
        BaseDataResponse baseDataResponse=new BaseDataResponse();

        Boolean response = null;
        try {
            response = importWareService.createImportWareHouse(request);
            baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
            baseDataResponse.setResponseMessage("Luu Thanh Cong");
            baseDataResponse.setBody(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
    @PostMapping("/export/create-or-update")
    public ResponseEntity<BaseDataResponse<Boolean>> exportCreate(@Valid @RequestBody ExportWareRequest request) {
        BaseDataResponse baseDataResponse=new BaseDataResponse();

        Boolean response = null;
        try {
            response = exportWareService.createImportWareHouse(request);
            baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
            baseDataResponse.setResponseMessage("Luu Thanh Cong");
            baseDataResponse.setBody(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }

    @PostMapping("/import/find-by-import-id")
    public ResponseEntity<BaseDataResponse<ImportInfoResponse>> getId(@Valid @RequestBody QueryBaseRequestById request) {
        BaseDataResponse baseDataResponse=new BaseDataResponse();

        ImportInfoResponse response = null;
        try {
            response = importWareService.getByImportId(request);
            baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
            baseDataResponse.setResponseMessage("Luu Thanh Cong");
            baseDataResponse.setBody(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
    @PostMapping("/export/find-by-export-id")
    public ResponseEntity<BaseDataResponse<ExportInfoResponse>> getExportId(@Valid @RequestBody QueryBaseRequestById request) {
        BaseDataResponse baseDataResponse = new BaseDataResponse();

        ExportInfoResponse response = null;
        try {
            response = exportWareService.getByImportId(request);
            baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
            baseDataResponse.setResponseMessage("Luu Thanh Cong");
            baseDataResponse.setBody(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
    @PostMapping("/import/on-search")
    public ResponseEntity<BaseDataResponse<ImportWare>> onsearch(@Valid @RequestBody ImportRequestSearch request){
        BaseDataResponse baseDataResponse = new BaseDataResponse();
        ImportResponse response=importWareService.pageSearch(request);
        baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
        baseDataResponse.setResponseMessage("Detail Student By Class");
        baseDataResponse.setBody(response);
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
    @PostMapping("/export/on-search")
    public ResponseEntity<BaseDataResponse<ExportWare>> onEXsearch(@Valid @RequestBody ImportRequestSearch request){
        BaseDataResponse baseDataResponse = new BaseDataResponse();
        ExportResponse response=exportWareService.pageSearch(request);
        baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
        baseDataResponse.setResponseMessage("Detail Student By Class");
        baseDataResponse.setBody(response);
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
    @PostMapping("/export/find-by-product-no")
    public ResponseEntity<BaseDataResponse<ListProviderInfoResponse>> getProviderByNo(@Valid @RequestBody ProductNoRequest productRequest) {
        BaseDataResponse baseDataResponse=new BaseDataResponse();

        ListProviderInfoResponse response = null;
        try {
            response = exportWareService.getByProductNo(productRequest);
            baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
            baseDataResponse.setResponseMessage("Thành công");
            baseDataResponse.setBody(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
}
