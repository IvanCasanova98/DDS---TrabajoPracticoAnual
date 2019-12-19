package TPZTBCS;
public abstract class PrendaBuilder
{
    protected Prenda prenda;
    protected JsonReader jsonReader;
    
    public abstract void buildParte();
    
    public abstract void buildTipo(String tipo) throws Exception;
    
    public abstract void buildMaterial(String material) throws Exception;
    
    public abstract void buildUrl (String img_url) throws Exception;
    
    public abstract void buildImagen () throws Exception;
    
    public void verificarColoresDistintos(String colorPrimario, String colorSecundario) throws Exception 
    {
    	if(colorPrimario.equals(colorSecundario)) throw new Exception("COLOR PRIMARIO Y SECUNDARIO IGUALES");
    }
    
    public void buildColorPrimario(String colorPrimario) throws Exception
    {
//    	if ((jsonReader.getColores()).contains(colorPrimario))
//    	{
    		prenda.setColorPrimario(colorPrimario);
//    	}
//    	else
//    	{
//    		throw new Exception("ERROR COLOR PRIMARIO"); 
//    	}    
    }
    
    public void buildColorSecundario(String colorSecundario) throws Exception
    {
//    	if ((jsonReader.getColores()).contains(colorSecundario))
//    	{
    		prenda.setColorSecundario(colorSecundario);
//    	}
//    	else
//    	{
//    		throw new Exception("ERROR COLOR SECUNDARIO"); 
//    	}     	
    }
    
    public void crearPrenda()
    {
    	prenda = new Prenda();
    }
    
    public Prenda getPrenda()
    {
    	return prenda;
    }
}