package br.com.mattec.clean.cleanarch.dataprovider.client;

import br.com.mattec.clean.cleanarch.dataprovider.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url = "${mattec.client.address.url}"
)
public interface FindAddressByZipCodeClient {

    @GetMapping("/{zipCode}/json/")
    AddressResponse find(@PathVariable("zipCode") final String zipCode);
}
