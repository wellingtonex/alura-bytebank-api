package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.customizacao.service.ClienteService;
import io.swagger.customizacao.util.RespostasUtil;
import io.swagger.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class ClienteApiController implements ClienteApi {

    private final ClienteService clienteService;
    private final RespostasUtil respostaUtil;

    public ResponseEntity<Cliente> cadastraCliente(@ApiParam(value = "") @Valid @RequestBody Cliente cliente_) {
        try {
            return clienteService.salva(cliente_);
        } catch (Exception e) {
            return respostaUtil.getErroInternoCliente(ClienteService.FALHA_AO_TENTAR_CADASTRAR_UM_CLIENTE);
        }
    }
}
