package com.customer.management.model;

import lombok.*;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    private String loginId;
    private String password;
}
