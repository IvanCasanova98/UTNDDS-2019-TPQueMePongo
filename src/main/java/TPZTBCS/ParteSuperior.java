package TPZTBCS;
public class ParteSuperior extends PrendaBuilder
{
	
    public ParteSuperior(){prenda = new Prenda();}
    
    public void buildParte(){prenda.setParte("Parte Superior");}
    
    public void buildTipo(String tipo) throws Exception
    {
    	if (JsonReader.getTipoParteSuperior().contains(tipo))
    	{
    		prenda.setStrategy(new noAbriga());
        	prenda.setTipo(tipo);
    	}
    	else if (JsonReader.getTipoAbrigos().contains(tipo)) 
    	{
    		prenda.setStrategy(new abrigo());
    		prenda.setTipo(tipo);
    		 
    	}else throw new Exception("ERROR TIPO");  
    	
    }
    
    public void buildMaterial(String material) throws Exception
    {
    	if (JsonReader.getMaterialParteSuperior().contains(material))
    	{
        	prenda.setMaterial(material);
    	}
    	else
    	{
    		throw new Exception("ERROR MATERIAL"); 
    	} 
    }
}