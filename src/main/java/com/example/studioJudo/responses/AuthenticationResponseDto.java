package com.example.studioJudo.responses;

import lombok.Builder;

@Builder
public record AuthenticationResponseDto(

        String token,

        String refreshToken

){
}
