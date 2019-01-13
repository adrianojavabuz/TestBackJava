package br.com.ConsultaConta.resource;

import java.net.URI;
import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.DesafioSantander.domain.Gastos;
import br.com.DesafioSantander.serivce.GastosService;
@RestController
@RequestMapping("/gastos")
public class GastosResource {

	
	@Autowired
    private GastosService gastosService;
 
    @GetMapping("/last")
    public Page<Gastos> listlast(@RequestParam(required = false) Map<String, String> filters,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) throws ParseException {
    	return gastosService.listtolast(filters, new PageRequest(page, size));
    }
    
    @GetMapping
    public Page<Gastos> list(@RequestParam(required = false) Map<String, String> filters,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) throws ParseException {
    	return gastosService.list(filters, new PageRequest(page, size));
    }
    
    @PostMapping
	public ResponseEntity<Void> registerGastos(
			 @RequestBody Gastos newGasto) {

    	Gastos gasto = gastosService.insert(newGasto);

		if (gasto == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(gasto.getId()).toUri();

		return ResponseEntity.created(location).build();
		
		
	}
 
}
