package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mail {
    private String mailTo;
    private String subject;
    private String message;
    private String toCc; // New field for CC

    public Optional<String> getToCc() {
        return Optional.ofNullable(toCc);
    }
}
