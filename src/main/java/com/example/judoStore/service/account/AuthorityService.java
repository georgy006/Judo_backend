package com.example.judoStore.service.account;

import com.example.judoStore.persistence.models.Customer;

public interface AuthorityService {

    Customer getCurrentUser();

//    boolean hasAnyAuthority(List<RoleName> roles);
//
//    void checkRolesAndThrow(List<RoleName> roles);
}
