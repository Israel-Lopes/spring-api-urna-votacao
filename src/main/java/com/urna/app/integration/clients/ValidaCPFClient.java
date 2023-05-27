package com.urna.app.integration.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url= "${route.validaCPF}" , name = "cpf")
public interface ValidaCPFClient {
    @RequestMapping(method = RequestMethod.GET)
    String getValidaCPF(@RequestParam("cpf") String cpf);
}
