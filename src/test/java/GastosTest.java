import java.text.ParseException;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;

import br.com.DesafioSantander.domain.Gastos;
import br.com.DesafioSantander.serivce.GastosService;

@RunWith(MockitoJUnitRunner.class)
public class GastosTest {

	@Mock
    private GastosService mockGastosService;

	@InjectMocks
    private Gastos gastos;
	
	GastosService gtest = Mockito.mock(GastosService.class);

    @Test
    public void shouldFindGastos() {
   
    	Map<String, String> filters=null;
    	PageRequest p = new PageRequest(0, 10);
    	Mockito.verify(gtest, Mockito.times(1)).list(filters, p);
    }
    

    @Test
    public void shouldFindGastoslast() throws ParseException {
   
    	Map<String, String> filters=null;
    	filters.put("datagasto","13/01/2019 15:35:13");
    	PageRequest p = new PageRequest(0, 10);
    	Mockito.verify(gtest, Mockito.times(1)).listtolast(filters, p);
    }
}
