package com.abstractionizer.Hello.World.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class SalesDetailsDto extends PageDto{

    @NotNull
    private Long customerId;

    @Nullable
    private Long orderId;

    @Nullable
    private String productName;

    @Nullable
    private LocalDateTime from;

    @Nullable
    private LocalDateTime to;
}
