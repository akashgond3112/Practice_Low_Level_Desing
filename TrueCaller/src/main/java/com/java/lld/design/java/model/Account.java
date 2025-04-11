package com.java.lld.design.java.model;

import com.java.lld.design.java.model.common.Contact;
import com.java.lld.design.java.model.common.PersonalInfo;
import com.java.lld.design.java.model.common.SocialInfo;
import com.java.lld.design.java.model.common.Tag;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class Account {
    String id;
    String phoneNumber;
    String username;
    String password;
    LocalDateTime lastAccessed;
    Tag tag;
    Contact contact;
    PersonalInfo personalInfo;
    SocialInfo socialInfo;

}
