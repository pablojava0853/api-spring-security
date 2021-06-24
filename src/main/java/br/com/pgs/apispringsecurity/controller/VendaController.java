package br.com.pgs.apispringsecurity.controller;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import br.com.pgs.apispringsecurity.entity.Venda;
import br.com.pgs.apispringsecurity.service.VendaService;

import java.util.List;

@RestController
@RequestMapping("api/v1/venda")
@AllArgsConstructor
public class VendaController {
	private final VendaService vendaService = new VendaService();

    @PostMapping
    public Venda salvar(@RequestBody Venda venda){
        return vendaService.salvar(venda);
    }

    @GetMapping("{cnpj}")
    public List<Venda> buscarPorCnpj(@PathVariable("cnpj") String cnpj){
        return vendaService.buscarPorCnpj(cnpj);
    }

}
