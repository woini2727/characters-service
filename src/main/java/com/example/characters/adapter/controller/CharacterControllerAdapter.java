package com.example.characters.adapter.controller;

import com.example.characters.adapter.model.CharacterControllerResponseModel;
import com.example.characters.application.port.in.DeleteCharacterCommand;
import com.example.characters.application.port.in.SaveCharacterCommand;
import com.example.characters.application.port.in.SearchCharacterQuery;
import com.example.characters.application.port.in.UpdateCharacterCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletionStage;

@RestController
@RequestMapping("/api/v1/characters")
@Slf4j
public class CharacterControllerAdapter {
    private final SearchCharacterQuery searchCharacterQuery;
    private final SaveCharacterCommand saveCharacterCommand;
    private final DeleteCharacterCommand deleteCharacterCommand;
    private final UpdateCharacterCommand updateCharacterCommand;

    public CharacterControllerAdapter(final SearchCharacterQuery searchCharacterQuery,
                                      final SaveCharacterCommand saveCharacterCommand,
                                      final DeleteCharacterCommand deleteCharacterCommand,
                                      final UpdateCharacterCommand updateCharacterCommand) {
        this.searchCharacterQuery = searchCharacterQuery;
        this.saveCharacterCommand = saveCharacterCommand;
        this.deleteCharacterCommand = deleteCharacterCommand;
        this.updateCharacterCommand = updateCharacterCommand;
    }


    @GetMapping("/{id}")
    public CompletionStage<CharacterControllerResponseModel> search(
            @PathVariable final int id
    ) {
        log.info("Call to get character by ID {}", id);

        return searchCharacterQuery.getById(id).thenApply(
                response ->{
                    log.info("Replying to get character by ID request with {}", response);
                    return CharacterControllerResponseModel.from(response);
                }
        );
    }

    @PostMapping
    public CompletionStage<CharacterControllerResponseModel> save(
            @Validated @RequestBody final CharacterRequestBody requestBody
    ) {
        log.info("call to POST character with body {}", requestBody);
        return saveCharacterCommand.save(requestBody.toDomain()).thenApply(
                response ->{
                    log.info("Replying to post character by ID request with {}", response);
                    return CharacterControllerResponseModel.from(response);
                }
        );
    }

    @PutMapping
    public CompletionStage<CharacterControllerResponseModel> update(
            @Validated @RequestBody final CharacterRequestBody requestBody
    ){
        log.info("Call to PUT character with body {}", requestBody);
        return updateCharacterCommand.update(requestBody.toDomain()).thenApply(
                response ->{
                    log.info("Replying to update character by ID request with {}", response);
                    return CharacterControllerResponseModel.from(response);
                }
        );    }

    @DeleteMapping("/{id}")
    public CompletionStage<CharacterControllerResponseModel> delete(
            @PathVariable final int id
    ){
        log.info("call to DELETE with character id {}", id);
        return deleteCharacterCommand.delete(id).thenApply(
                response ->{
                    log.info("Replying to delete character by ID request with {}", id);
                    return CharacterControllerResponseModel.from(response);
                }
        );    }

}
