package com.example.characters.application.port.in;

import com.example.characters.domain.Character;

import java.util.concurrent.CompletionStage;

public interface DeleteCharacterCommand {
    CompletionStage<Character> delete(int id);

}
