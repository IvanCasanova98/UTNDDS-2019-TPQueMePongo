public class Reloj extends Prenda implements IAccesorios
{
	public Reloj(String color,String material) 
	{
		super(color,material);
		this.tipo="Accesorio";
	}	

	public String getParteCuerpo() 
	{
		return IAccesorios.Parte;
	}
}