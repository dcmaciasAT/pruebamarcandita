package com.atsistemas.dcmacias.controller;

import javax.validation.constraints.NotBlank;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.atsistemas.dcmacias.dtos.UserDto;
import com.atsistemas.dcmacias.service.UserService;

import static io.micronaut.http.MediaType.APPLICATION_JSON;

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
            content = @Content(mediaType = "application/json",
                    schema = @Schema(type="UserDto"))
    )
    @ApiResponse(responseCode = "400", description = "Invalid id Supplied")
    @ApiResponse(responseCode = "500", description = "Remote error, server is going nuts")
    @Tag(name = "create")
    public Single<HttpResponse<UserDto>> create(@Body @NotBlank String name, @NotBlank String lastName, @NotBlank long phone) {
        return Single.just(HttpResponse.created(userService.create(name,lastName,phone)));
    }
    

}
