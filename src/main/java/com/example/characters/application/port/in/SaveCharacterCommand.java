package com.example.characters.application.port.in;

import com.example.characters.domain.Character;

import java.util.concurrent.CompletionStage;

public interface SaveCharacterCommand {

    CompletionStage<Character> save(Character character);
}
