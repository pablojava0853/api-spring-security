package br.com.pgs.apispringsecurity.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.pgs.apispringsecurity.entity.Venda;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{
	List<Venda> findAllByCnpj(String cnpj);
}
