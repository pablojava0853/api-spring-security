package br.com.pgs.apispringsecurity.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import br.com.pgs.apispringsecurity.entity.Venda;
import br.com.pgs.apispringsecurity.repository.VendaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class VendaService {
	
	private final VendaRepository repository = null;

    public Venda salvar(Venda venda){
        return repository.save(venda);
    }

    public List<Venda> buscarPorCnpj(String cnpj){
        return repository.findAllByCnpj(cnpj);
    }
}
