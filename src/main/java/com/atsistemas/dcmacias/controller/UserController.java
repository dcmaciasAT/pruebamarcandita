package com.atsistemas.dcmacias.controller;

import static io.micronaut.http.MediaType.APPLICATION_JSON;

import javax.validation.constraints.NotBlank;

import com.atsistemas.dcmacias.domain.User;
import com.atsistemas.dcmacias.dtos.UserDto;
import com.atsistemas.dcmacias.service.UserService;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@ExecuteOn(TaskExecutors.IO) 
@Controller("/") 
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Post(uri="/users", produces= APPLICATION_JSON)
    @Operation(summary = "Creates a new user object",
            description = "Showcase of the creation of a dto"
    )
    @ApiResponse(responseCode = "201", description = "User object correctly created",
            content = @Content(mediaType = "application/json",schema = @Schema(type="ContactDto"))
    )
    @ApiResponse(responseCode = "400", description = "Invalid id Supplied")
    @ApiResponse(responseCode = "500", description = "Remote error, server is going nuts")
    @Tag(name = "create")
    public Single<HttpResponse<UserDto>> create(@Body @NotBlank String name, @NotBlank String lastName, @NotBlank Long phone) {
        return Single.just(HttpResponse.created(userService.create(name,lastName,phone)));
    }


    @Put(uri="/contacts/{id}", produces= APPLICATION_JSON)
    @Operation(summary = "Updates an existing User object with a list of new contacts",
            description = "Showcase of the update of a dto"
    )
    @ApiResponse(responseCode = "200", description = "User object correctly updated",
            content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "404", description = "User not found by using the provided id")
    @ApiResponse(responseCode = "500", description = "Remote error, server is going nuts")
    @Tag(name = "updateContacts")
    public Single<HttpResponse<User>> updateContacts(@NotBlank Long id, ) {
        return Single.just(userService.updateContacts(id, null)
                .map(HttpResponse::ok)
                .orElseGet(HttpResponse::notFound)
        );
    }
    

}
