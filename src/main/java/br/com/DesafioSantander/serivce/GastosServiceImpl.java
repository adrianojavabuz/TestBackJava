package br.com.DesafioSantander.serivce;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.DesafioSantander.domain.Gastos;
import br.com.DesafioSantander.repository.GastosRepository;
import static br.com.DesafioSantander.specification.GastosSpecification.filterWithOptions;

@Service
public class GastosServiceImpl implements GastosService{
	
	
	  @Autowired
	    private GastosRepository gastosRepository;
	  
	@Override
	public Page<Gastos> list(Map<String, String> filters, Pageable pageable) {
		 return gastosRepository.findAll(filterWithOptions(filters), pageable);
	}

	@Override
	public Gastos insert(Gastos newgasto) {
		return gastosRepository.save(newgasto);
		
	}
	
	@Override
	public Page<Gastos> listtolast(Map<String, String> filters, Pageable pageable) throws ParseException {
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date date = (Date)formatter.parse(filters.get("datagasto"));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, -5);
		filters.put("datagasto",String.valueOf(calendar.getTime()));
		 return gastosRepository.findAll(filterWithOptions(filters), pageable);
	}

}
