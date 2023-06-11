package com.spirngauth.authentication_spring.services.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.spirngauth.authentication_spring.payload.request.categories.ReqCategory;
import com.spirngauth.authentication_spring.payload.response.BaseResponse;
import com.spirngauth.authentication_spring.payload.response.ResPayload;

public interface ICategories {
    ResPayload getCategories();
    BaseResponse createCategories(ReqCategory req) throws FileNotFoundException, IOException, Exception;
    BaseResponse response(Boolean flag);
    BaseResponse response(Boolean flag,String msg);
}
