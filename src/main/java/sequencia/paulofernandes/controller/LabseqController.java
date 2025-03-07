package sequencia.paulofernandes.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import sequencia.paulofernandes.service.LabseqService;

import java.util.List;

@Path("/labseq")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LabseqController {

    @Inject
    private LabseqService labseqService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    @Operation(
            summary = "Calcula e retorna o total da sequência l(n) de 0 até 100.000",
            description = "Este endpoint calcula a sequência de l(n) de 0 até 100.000."
    )
    @APIResponse(
            responseCode = "200",
            description = "Cálculo com o total da sequência realizado com sucesso",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "500",
            description = "Erro interno no servidor",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public List<Long> getLabseqValueTotal() {

        // Retorna todos os valores de l(0) a l(100000)
        return labseqService.calculateLabseqTotal(100000);
    }

    @GET
    @Path("/{n}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Calcula e retorna o valor da sequência l(n)",
            description = "Este endpoint calcula o valor da sequência de l(n)"
    )
    @APIResponse(
            responseCode = "200",
            description = "Cálculo do valor da sequência realizado com sucesso",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "500",
            description = "Erro interno no servidor",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public String getLabseqValue(@PathParam("n") int n) {
        long result = labseqService.calculateLabseq(n);
        return String.valueOf(result);
    }
}
