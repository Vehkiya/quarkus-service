package dev.vehki

import kotlinx.serialization.Serializable
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/recipe")
class RecipeResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun find(@QueryParam("name") name: String): RecipeDto {
        return RecipeDto(name)
    }

    @Serializable
    data class RecipeDto(val name: String) {
        init {
            require(name.isNotBlank()) { "Name cannot be blank" }
        }
    }
}