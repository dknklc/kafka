package com.dekankilic.useraddressservice.service;

import com.dekankilic.useraddressservice.entity.Address;
import com.dekankilic.useraddressservice.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Address saveAddress(Address address){
        return addressRepository.save(address);
    }

    public Address findAddressByUserId(Long userId){
        return addressRepository.findByUserId(userId);
    }
}
