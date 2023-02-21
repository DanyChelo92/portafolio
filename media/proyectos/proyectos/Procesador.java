package Swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Procesador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoProcesador marco= new MarcoProcesador();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}

class MarcoProcesador extends JFrame{
	public MarcoProcesador() {
		setTitle("Procesador");
		setBounds(400, 200, 500, 400);
		LamProcesador lam= new LamProcesador();
		add(lam);
	}
}

class LamProcesador extends JPanel{
	JTextPane area;
	JMenu fuente, estilo, tamano;
	Font letras;
	public LamProcesador() {
		setLayout(new BorderLayout());
		JPanel  lamMenu= new JPanel();
		JMenuBar barra= new JMenuBar();
		//--------------------------------------------
		fuente= new JMenu("Fuente");
		estilo= new JMenu("Estilo");
		tamano= new JMenu("Tamaño");
		//--------------------------------------------
		/*
		 * JMenuItem arial= new JMenuItem("Arial"); arial.addActionListener(new
		 * ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 * method stub area.setFont(new Font("Arial",Font.PLAIN,12)); } }); JMenuItem
		 * courier= new JMenuItem("Courier"); //GestionaMenu letra= new GestionaMenu();
		 * //courier.addActionListener(new GestionaMenu());
		 * courier.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 * method stub area.setFont(new Font("Courier",Font.PLAIN,12)); } }); JMenuItem
		 * verdana= new JMenuItem("Verdana"); verdana.addActionListener(new
		 * ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 * method stub area.setFont(new Font("Verdana",Font.PLAIN,12)); } });
		 * fuente.add(arial); fuente.add(courier); fuente.add(verdana);
		 * //-------------------------------------------- JMenuItem negrita= new
		 * JMenuItem("Negrita"); JMenuItem cursiva= new JMenuItem("Cursiva");
		 * estilo.add(negrita); estilo.add(cursiva);
		 */
		//--------------------------------------------
		/*
		 * JMenuItem tam12= new JMenuItem("12"); JMenuItem tam16= new JMenuItem("16");
		 * JMenuItem tam20= new JMenuItem("20"); JMenuItem tam24= new JMenuItem("24");
		 * tamano.add(tam12); tamano.add(tam16); tamano.add(tam20); tamano.add(tam24);
		 */
		//--------------------------------------------
		
		confMenu("Arial", "fuente","Arial",9,10);
		confMenu("Courier", "fuente","Courier",9,10);
		confMenu("Verdana", "fuente","Verdana",9,10);
		//--------------------------------------------
		confMenu("Negrita", "estilo","",Font.BOLD,1);
		confMenu("Cursiva", "estilo","",Font.ITALIC,1);
		//--------------------------------------------
		confMenu("12", "tamano","",9,12);
		confMenu("16", "tamano","",9,16);
		confMenu("20", "tamano","",9,20);
		confMenu("24", "tamano","",9,24);
		//--------------------------------------------
		
		
		barra.add(fuente);
		barra.add(estilo);
		barra.add(tamano);
		lamMenu.add(barra);
		add(lamMenu,BorderLayout.NORTH);
		
		area= new JTextPane();
		add(area,BorderLayout.CENTER);
		
		
	}
	
	public void confMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam ) {
		JMenuItem elemMenu= new JMenuItem(rotulo);
		if(menu=="fuente") {
			fuente.add(elemMenu);
		} else if(menu=="estilo") {
			estilo.add(elemMenu);
		} else if (menu=="tamano") {
			tamano.add(elemMenu);
		}	
		
		elemMenu.addActionListener(new GestionaEvento(rotulo, tipoLetra, estilos, tam));
	}
	
	private class GestionaEvento implements ActionListener{
		String tipoTexto, menu;
		int estiloLetra, tamanoLetra;
		
		GestionaEvento (String elemento, String texto2, int estilo2, int tamLetra){
			tipoTexto=texto2;
			estiloLetra=estilo2;
			tamanoLetra=tamLetra;
			menu=elemento;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			letras=area.getFont();
			if(menu=="Arial" || menu=="Courier" || menu=="Verdana") {
				estiloLetra=letras.getStyle();
				tamanoLetra=letras.getSize();
			} else if(menu=="Cursiva" || menu=="Negrita") {
				if(letras.getStyle()==1 || letras.getStyle()==2) {
					estiloLetra=3;
				}
				tipoTexto=letras.getFontName();
				tamanoLetra=letras.getSize();
			} else if(menu=="12" || menu=="16" || menu=="20" || menu=="24") {
				estiloLetra=letras.getStyle();
				tipoTexto=letras.getFontName();
			}
			
			area.setFont(new Font(tipoTexto,estiloLetra,tamanoLetra));
			System.out.println("Tipo: "+tipoTexto+" Estilo: "+estiloLetra+" Tamaño: "+tamanoLetra);
		}
		
	}
	
	/*
	 * private class GestionaMenu implements ActionListener{
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
	 * method stub area.setFont(new Font("Courier",Font.PLAIN,12)); }
	 * 
	 * }
	 */
}





