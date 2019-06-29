import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

public class Evento extends TimerTask implements comando {

	public Atuendo AtuendoElegido=null; 
	public Date FechaDelEvento;
	public Usuario usuario; 
	public Atuendo Sugerencia=null; 
	
	public Evento(Date fecha,Usuario ID) {
		this.FechaDelEvento=fecha;
		this.usuario = ID;
	}

	@Override
	public void ejecutar() {
		this.AtuendoElegido=this.Sugerencia;
		
	}

	@Override
	public void deshacer() {
		usuario.listaEvento.remove(this);
		
	}

	@Override
	public void rechazar() {
		this.run();
		
	}

	@Override
	public void run() {
		try {
        
		List<Atuendo>listaSugerencias =usuario.queMePongoATodosLosGuardarropas();
		int rnd = new Random().nextInt(listaSugerencias.size());
		 Atuendo atuendoElegido = listaSugerencias.get(rnd);
		 this.Sugerencia = atuendoElegido;
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
