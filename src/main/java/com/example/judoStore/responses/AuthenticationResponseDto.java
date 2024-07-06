package com.example.judoStore.responses;

import lombok.Builder;

@Builder
public record AuthenticationResponseDto(

        String token,

        String refreshToken

){
}