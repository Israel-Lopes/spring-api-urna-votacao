package com.urna.app.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url= "${route.validaCPF}" , name = "cpf")
public interface ValidaCPFClient {
    @RequestMapping(method = RequestMethod.GET, value = "/cpf")
    List<MovieLukeSkyWalker> getMoviesSkyWalker();
}
