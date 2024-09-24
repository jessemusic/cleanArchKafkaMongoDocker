package br.com.mattec.clean.cleanarch.dataprovider;

import br.com.mattec.clean.cleanarch.core.dataprovider.FindAddressByZipCode;
import br.com.mattec.clean.cleanarch.core.domain.Address;
import br.com.mattec.clean.cleanarch.dataprovider.client.FindAddressByZipCodeClient;
import br.com.mattec.clean.cleanarch.dataprovider.client.mapper.AddressResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var adressResponse = this.findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(adressResponse);
    }
}
