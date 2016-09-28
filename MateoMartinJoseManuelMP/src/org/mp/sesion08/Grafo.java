package org.mp.sesion08;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Grafo extends JFrame {

	private JPanel contentPane;
	private JButton bSeleccion;
	private int numVertices;
	private ArrayList<Vertice> vertices;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafo frame = new Grafo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Grafo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bSeleccion = new JButton("Seleccionar Archivo");
		bSeleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String directorioEntrada = System.getProperty("user.dir");
				directorioEntrada = directorioEntrada + File.separator + "src"
						+ File.separator + "org" + File.separator + "mp"
						+ File.separator + "sesion08" + File.separator;
				JFileChooser elegirArchivo = new JFileChooser(directorioEntrada);
				FileFilter ff = new FileNameExtensionFilter ("extension TXT", "txt");
				elegirArchivo.setFileFilter(ff);
				elegirArchivo.showOpenDialog(contentPane);
				try {
					File f = elegirArchivo.getSelectedFile();
					BufferedReader br = new BufferedReader (
							new FileReader (f));
					String linea;
					linea = br.readLine();
					numVertices = Integer.parseInt(linea);
					//creo mi lista de vertices
					vertices = new ArrayList<Vertice>();
					for (int i=0; i<numVertices; i++) {
						linea = br.readLine();
						Vertice v = new Vertice (linea);
						vertices.add(v);
					}
					//creo mi lista de aristas
					for (int i=0; i<numVertices; i++) {
						linea = br.readLine();
						StringTokenizer cadena = new StringTokenizer (linea, " ");
						int n = Integer.parseInt(cadena.nextToken()); 
						while (cadena.hasMoreTokens()) {
							int ady = Integer.parseInt(cadena.nextToken());
							vertices.get(n).addAyacentes (vertices.get(ady));
						}
					}
					
					repaint();
					br.close();
				}
				catch (Exception e) {
					
				}
			}
		});
		bSeleccion.setFont(new Font("Tahoma", Font.BOLD, 16));
		bSeleccion.setBounds(0, 0, 584, 60);
		contentPane.add(bSeleccion);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for (int i=0; i<numVertices; i++) {
			Vertice v = vertices.get(i);
			g.drawString(v.getNumVertice()+"", v.getPosX()+30, v.getPosY()+100);
			g.fillOval(v.getPosX()+30, v.getPosY()+100, 20, 20);
			for (int j=0; j<v.getAdyacentes().size(); j++) {
				Vertice ady = v.getAdyacentes().get(j);
				g.drawLine(v.getPosX()+30+10, v.getPosY()+100+10, ady.getPosX()+30+10, ady.getPosY()+100+10);
			}
		}
	}
}

