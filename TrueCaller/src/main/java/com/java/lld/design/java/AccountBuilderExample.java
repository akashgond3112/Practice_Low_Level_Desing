package com.java.lld.design.java;


import com.java.lld.design.java.model.Account;
import com.java.lld.design.java.model.common.Address;
import com.java.lld.design.java.model.common.Contact;
import com.java.lld.design.java.model.common.PersonalInfo;
import com.java.lld.design.java.model.common.SocialInfo;
import com.java.lld.design.java.model.common.SocialProfileType;
import com.java.lld.design.java.model.common.Tag;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class AccountBuilderExample {
    
    public static void main(String[] args) {
        // Example of building an Account object using the builder pattern
        
        // Create address
        Address address = Address.builder()
                .addressLine1("123 Main St")
                .addressLine2("Apt 4B")
                .street("Main Street")
                .city("New York")
                .country("USA")
                .pinCode("10001")
                .build();
        
        // Create personal info using custom builder that requires firstName
        PersonalInfo personalInfo = PersonalInfo.builder("John")
                .lastName("Doe")
                .dob("1990-01-01")
                .gender("Male")
                .address(address)
                .company("ACME Inc")
                .build();
        
        // Create contact information
        Contact contact = Contact.builder()
                .countryCode("+1")
                .email("john.doe@example.com")
                .phoneNumber("555-1234")
                .build();
        
        // Create social media information
        Map<SocialProfileType, String> socialProfiles = new HashMap<>();
        socialProfiles.put(SocialProfileType.FACEBOOK, "john.doe");
        socialProfiles.put(SocialProfileType.TWITTER, "@johndoe");
        
        SocialInfo socialInfo = SocialInfo.builder()
                .build();
        // Add social profiles to the immutable map
        socialProfiles.forEach((key, value) -> socialInfo.getSocialInfo().put(key, value));
        
        // Build the complete account
        Account account = Account.builder()
                .id(UUID.randomUUID().toString())
                .username("johndoe")
                .password("securePassword123")
                .phoneNumber("555-1234")
                .tag(Tag.EDUCATION)
                .contact(contact)
                .personalInfo(personalInfo)
                .socialInfo(socialInfo)
                .lastAccessed(LocalDateTime.now())
                .build();

		log.info("Created account: {}", account);
    }
}
