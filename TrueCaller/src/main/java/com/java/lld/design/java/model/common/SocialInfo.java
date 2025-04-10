package com.java.lld.design.java.model.common;

import lombok.Builder;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;

@Value
@Builder
public class SocialInfo {
    Map<SocialProfileType,String> socialInfo= new HashMap<>();
}
