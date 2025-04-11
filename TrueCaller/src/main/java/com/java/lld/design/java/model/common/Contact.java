package com.java.lld.design.java.model.common;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Contact {
    String countryCode;
    String email;
    String phoneNumber;
}
