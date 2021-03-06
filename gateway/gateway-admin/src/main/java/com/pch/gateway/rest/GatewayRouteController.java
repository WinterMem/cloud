package com.pch.gateway.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pch.gateway.model.dto.GatewayRouteDto;
import com.pch.gateway.service.GatewayRouteService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <P>路由管理 给admin使用</P>
 *
 * @Author: pch
 * @Date: 2020-12-12 11:50
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/gateway/route")
public class GatewayRouteController {

    private final GatewayRouteService gatewayRouteService;

    @PostMapping("/add")
    public Mono<Boolean> add(@Valid @RequestBody List<GatewayRouteDto> gatewayRouteDtos) {
        return Mono.just(gatewayRouteService.saveOrUpdate(gatewayRouteDtos));
    }

    @PostMapping("/overload")
    public Mono<Boolean> overload() {
        return Mono.just(gatewayRouteService.overload());
    }

    @GetMapping("/findAll")
    public Flux<GatewayRouteDto> findAll() {
        return Flux.fromIterable(gatewayRouteService.findAll());
    }

    @DeleteMapping("/del/{id}")
    public Mono<Boolean> del(@PathVariable String id) {
        return Mono.just(gatewayRouteService.delete(id));
    }

}
