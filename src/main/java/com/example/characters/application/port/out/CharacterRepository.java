package com.example.characters.application.port.out;

import com.example.characters.domain.Character;

public interface CharacterRepository {
    Character getById(int id);
}
