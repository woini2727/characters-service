package com.example.characters.adapter.controller;

import com.example.characters.domain.Character;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class CharacterRequestBody {
    @NonNull String name;
    @NonNull Integer height;
    @NonNull Integer mass;
    @NonNull String hairColor;
    @NonNull String eyeColor;
    @NonNull String birthYear;
    @NonNull String gender;
    @NonNull LocalDateTime createdAt;
    @NonNull LocalDateTime updatedAt;

    public Character toDomain(){
        return Character.builder()
                .name(name)
                .height(height)
                .mass(mass)
                .hairColor(hairColor)
                .eyeColor(eyeColor)
                .birthYear(birthYear)
                .gender(gender)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
}
}
