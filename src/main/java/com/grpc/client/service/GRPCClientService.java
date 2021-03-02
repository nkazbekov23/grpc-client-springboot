package com.grpc.client.service;

import com.grpc.server.springboot.grpcserver.GrpcServerServiceGrpc;
import com.grpc.server.springboot.grpcserver.SomeRequest;
import com.grpc.server.springboot.grpcserver.SomeResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class GRPCClientService {

    public String client(String value) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        GrpcServerServiceGrpc.GrpcServerServiceBlockingStub stub = GrpcServerServiceGrpc.newBlockingStub(channel);

        SomeResponse response = stub.req(SomeRequest.newBuilder()
                .setValue(value)
                .build());

        channel.shutdownNow();

        return response.getValue();
    }
}
