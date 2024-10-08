package com.technexushub.dtos;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageResponse {
    private String message;
    private String imageName;
    private boolean success;
    private HttpStatus status;
}
