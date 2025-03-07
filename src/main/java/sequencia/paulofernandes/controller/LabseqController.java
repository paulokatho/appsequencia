package sequencia.paulofernandes.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import sequencia.paulofernandes.service.LabseqService;

@Path("/labseq")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LabseqController {

    @Inject
    private LabseqService labseqService;

    @GET
    @Path("/{n}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(
            summary = "Calcula e retorna o valor da sequência l(n)",
            description = "Este endpoint calcula o valor da sequência de l(n)"
    )
    @APIResponse(
            responseCode = "200",
            description = "Cálculo do valor da sequência realizado com sucesso",
            content = @Content(mediaType = MediaType.TEXT_PLAIN)
    )
    @APIResponse(
            responseCode = "500",
            description = "Erro interno no servidor",
            content = @Content(mediaType = MediaType.TEXT_PLAIN)
    )
    public String getLabseqValue(@PathParam("n") int n) {
        if (n <= 0) {
            throw new NullPointerException("Somente números positivos!");
        }

        long result = 0;
        try {
            result = labseqService.calculateLabseq(n);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return String.valueOf(result);
    }

}

