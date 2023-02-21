package Layouts;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculardora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCal marco= new MarcoCal();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoCal extends JFrame{
	public MarcoCal() {
		setTitle("Calculeitor");
		setBounds(500,200,200,250);
		
		LaminaCal lam= new LaminaCal();
		add(lam);
		//por defecto crea el marco con el tamaño del contenido con su valor predetermiando
		//pack();
	}
}

class LaminaCal extends JPanel{
	private JPanel lam2;
	private JButton pantalla;
	private boolean principio;
	private double resultado;
	private String ultimaop;
	
	public LaminaCal() {
		principio=true;
		setLayout(new BorderLayout());
		pantalla= new JButton("0");
		pantalla.setEnabled(false);
		add(pantalla,BorderLayout.NORTH);
		lam2= new JPanel();
		lam2.setLayout(new GridLayout(4,4));
		
		ActionListener insertar=new InsertarNumero();
		ActionListener accion= new AccionOrden();
		 //No funciona probar otra cosa
		  JButton boton; 
		  String [] num= {"7","8","9","/","4","5","6","*","1","2","3","-","0",",","+","="}; 
		  for(int i=0;i<num.length;i++) { 
			  boton= new JButton(num[i]);
		  if(!num[i].equals("/") && !num[i].equals("*") && !num[i].equals("-") && !num[i].equals("+") && !num[i].equals(",") && !num[i].equals("=") ) {
			 boton.addActionListener(insertar); 
		 }else {
			 boton.addActionListener(accion);
		 }
		  lam2.add(boton);
		  }
			
		/*
		 * ponerBoton("7",insertar); ponerBoton("8",insertar); ponerBoton("9",insertar);
		 * //ponerBoton("/");
		 * 
		 * ponerBoton("4",insertar); ponerBoton("5",insertar); ponerBoton("6",insertar);
		 * //ponerBoton("*");
		 * 
		 * ponerBoton("1",insertar); ponerBoton("2",insertar); ponerBoton("3",insertar);
		 * //ponerBoton("-");
		 * 
		 * ponerBoton("0",insertar); ponerBoton(",",insertar); ponerBoton("+",insertar);
		 * // ponerBoton("=");
		 * 
		 */
		
		add(lam2, BorderLayout.CENTER);
		ultimaop="=";
	}
	
	/*
	 * private void ponerBoton(String rotulo, ActionListener oyente) { JButton boton
	 * = new JButton(rotulo); boton.addActionListener(oyente); lam2.add(boton); }
	 */
	 
	
	private class InsertarNumero implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String entrada = e.getActionCommand();
			if(principio) {
				pantalla.setText("");
				principio=false;
			}
			pantalla.setText(pantalla.getText()+entrada);
		}
		
	}
	
	private class AccionOrden implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String operacion= e.getActionCommand();
			calcular(Double.parseDouble(pantalla.getText())); 
			ultimaop=operacion;
			principio=true;
			
		}
		
		public void calcular(double x) {
			
			if(ultimaop.equals("+")) {
				resultado+=x;
			}else if(ultimaop.equals("-")) {
				resultado-=x;
			}
			else if(ultimaop.equals("*")) {
				resultado*=x;
			}
			else if(ultimaop.equals("/")) {
				resultado/=x;
			}
			else if(ultimaop.equals("=")) {
				resultado=x;
			}
		
			pantalla.setText(""+resultado);
			
		}
	}
}



