package com.spirngauth.authentication_spring.interfaces;

import java.util.List;

import com.spirngauth.authentication_spring.models.Attributes;
import com.spirngauth.authentication_spring.payload.response.ResPayload;

public interface IAttributes {
    ResPayload findAllAttribute();
}
