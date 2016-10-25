
import java.util.Scanner;

public class ej {
	public static class circular{
		int dato;
		circular sgte;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		circular cab=null;
		int op;
		do{
			op=leer("1.añadir nodo\n2.listar\n3.Añadir nodo en la posicion x\n4.Quitar nodo posicion x\n5.Volver lineal");
			switch(op){
			case 1:
				cab=add_c(cab);
				break;
			case 2:
				listado(cab);
				break;
			case 3:
				cab=add_x(cab,leer("posicion?"));
				break;
			case 4:
				cab=quitar_x(cab,leer("posicion?"));
				break;
			case 5:
				cab=lineal(cab);
				
			}
		}while(op!=6);

	}
	public static circular lineal(circular p){
		circular z;
		if (p!=null) {
			z=p;
			while(z.sgte!=p){
				z=z.sgte;
			}
			z.sgte=null;
		}
		return p;
	}
	public static circular add_c(circular cab){
		circular aux;
		circular nuevo=crear_nuevo("Dato?");
		if(cab==null){
			cab=nuevo;
		}else{
			aux=cab.sgte;
			while(aux.sgte!=cab){
				aux=aux.sgte;
			}
			nuevo.sgte=cab;
			aux.sgte=nuevo;
		}
		return cab;
	}
	public static circular add_x(circular cab,int x){
		circular aux;
		circular nuevo=crear_nuevo("Dato?");
		if(cab==null){
			cab=nuevo;
		}else{
			if(x==1){
				nuevo.sgte=cab;
				cab=nuevo;
			}
			else if(contar(cab)>x){
				aux=cab.sgte;
				for (int i = 1; i < x-2; i++) {
					aux=aux.sgte;
				}
				nuevo.sgte=aux.sgte;
				aux.sgte=nuevo;
			}else if(x==contar(cab)){
				aux=cab.sgte;
				while(aux.sgte!=cab){
					aux=aux.sgte;
				}
				nuevo.sgte=cab;
				aux.sgte=nuevo;
			}
			
		}
		return cab;
	}
	public static circular quitar_x(circular cab,int x){
		circular aux;
		if(cab!=null){
			if(x==1&&contar(cab)==1){
				cab=null;
			}else if(x==1){
				aux=cab.sgte;
				while(aux.sgte!=cab){
					aux=aux.sgte;
				}
				aux.sgte=cab.sgte;
				cab=aux.sgte;
			}else if(contar(cab)>=x){
				aux=cab.sgte;
				circular a=aux.sgte;
				for (int i = 2; i < x-1; i++) {
					aux=aux.sgte;
					a=a.sgte;
				}
				aux.sgte=a.sgte;
			}
		}
		return cab;
	}
	public static circular crear_nuevo(String t){
		circular x= new circular();
		x.dato=leer(t);
		x.sgte=x;
		return x;
	}
	public static void listado(circular p){
		circular z;
		if (p!=null) {
			z=p;
			while(z.sgte!=p){
				System.out.println(z.dato);
				z=z.sgte;
			}
			System.out.println(z.dato);
		}
	}
	public static int leer (String msg){
		Scanner lee = new Scanner(System.in);
		System.out.println(msg);
		return lee.nextInt();
		
	}
	public static int contar (circular z){
		int c=0;
		if(z!=null){
			if(z.sgte==z){
				c=1;
			}else{
				circular aux=z.sgte;
				c=1;
				while(aux.sgte!=z){
					c++;
					aux=aux.sgte;
				}
			}
		}
		return c;
	}

}
