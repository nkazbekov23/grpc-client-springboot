package com.grpc.client.controller;

import com.grpc.client.service.GRPCClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrpsController {

    private final GRPCClientService grpcClientService;

    public GrpsController(GRPCClientService grpcClientService) {
        this.grpcClientService = grpcClientService;
    }

    @GetMapping("/req")
    public String reqClient(@RequestParam(defaultValue = "client") String value) {
        return grpcClientService.client(value);
    }

    @GetMapping("/test")
    public String getStringForTest() {
        return "hello test";
    }
}
