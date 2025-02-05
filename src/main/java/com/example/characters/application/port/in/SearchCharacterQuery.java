package com.example.characters.application.port.in;

import com.example.characters.domain.Character;

import java.util.concurrent.CompletionStage;

public interface SearchCharacterQuery {
    CompletionStage<Character> getById(int id);
}
