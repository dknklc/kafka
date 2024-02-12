package com.dekankilic.useraddressservice.controller;

import com.dekankilic.useraddressservice.entity.Address;
import com.dekankilic.useraddressservice.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{userId}")
    public Address getAddressByUserId(@PathVariable Long userId){
        return addressService.findAddressByUserId(userId);
    }
}
