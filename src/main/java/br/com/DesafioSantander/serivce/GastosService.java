package br.com.DesafioSantander.serivce;

import br.com.DesafioSantander.specification.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.Map;
import br.com.DesafioSantander.domain.Gastos;


public interface GastosService {

	Page<Gastos> list(Map<String,String> filters, Pageable pageable);
	
	Gastos insert(Gastos newgasto);
	
	Page<Gastos> listtolast(Map<String,String> filters, Pageable pageable) throws ParseException;
	
}
