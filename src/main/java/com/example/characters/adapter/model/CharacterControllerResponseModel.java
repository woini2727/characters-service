package com.example.characters.adapter.model;

import com.example.characters.domain.Character;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class CharacterControllerResponseModel {
    @NonNull String name;
    Integer height;
    Integer mass;
    @NonNull String hairColor;
    @NonNull String eyeColor;
    @NonNull String birthYear;
    @NonNull String gender;
    @NonNull LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public static CharacterControllerResponseModel from(Character domain) {
        return CharacterControllerResponseModel.builder()
                .name(domain.getName())
                .height(domain.getHeight())
                .mass(domain.getMass())
                .hairColor(domain.getHairColor())
                .eyeColor(domain.getEyeColor())
                .birthYear(domain.getBirthYear())
                .gender(domain.getGender())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }
}

