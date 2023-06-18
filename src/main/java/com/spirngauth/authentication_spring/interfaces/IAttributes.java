package com.spirngauth.authentication_spring.interfaces;

import java.util.List;

import com.spirngauth.authentication_spring.models.Attributes;

public interface IAttributes {
    List<Attributes> findAllAttribute();
}
