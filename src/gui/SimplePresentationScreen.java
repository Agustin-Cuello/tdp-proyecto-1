package gui;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import java.time.*;
import java.util.Date;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private JLabel LBL_LU;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel GITHUB_LBL;
	private JTextField CampoLU;
	private JTextField CampoApellido;
	private JTextField CampoNombre;
	private JTextField CampoEmail;
	private JTextField CampoGithub;
	private JLabel fechayhora;
	private JLabel LBL_IMAGEN;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(639, 266));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
		
		
		
		//Establece como valor de los textfield la información del estudiante
		CampoLU.setText(Integer.toString(studentData.getId()));
		CampoNombre.setText(studentData.getFirstName());
		CampoApellido.setText(studentData.getLastName());
		CampoEmail.setText(studentData.getMail());
		CampoGithub.setText(studentData.getGithubURL());
		
		SimpleDateFormat formatter= new SimpleDateFormat(" 'Esta ventana fue generada el' dd-MM-yyyy 'a las:' HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		
		fechayhora = new JLabel(formatter.format(date));
		fechayhora.setBounds(5, 212, 430, 14);
		contentPane.add(fechayhora);
		
		LBL_IMAGEN = new JLabel("Imagen");
		LBL_IMAGEN.setBorder(new LineBorder(new Color(0, 0, 0)));
		LBL_IMAGEN.setBounds(453, 11, 155, 205);
		contentPane.add(LBL_IMAGEN);
		
		
		//Creo un objeto imagen para almacenar el recurso recuperado del path
		Image image = new ImageIcon(this.getClass().getResource(studentData.getPathPhoto())).getImage();
		
		//Escalo la imagen al tamaño definido por el JLabel donde se mostrará
		Image imagen_escalada = image.getScaledInstance(LBL_IMAGEN.getWidth(), LBL_IMAGEN.getHeight(), java.awt.Image.SCALE_SMOOTH);
		ImageIcon iconoLabel = new ImageIcon(imagen_escalada);
		
		LBL_IMAGEN.setIcon(iconoLabel);

	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 205);
		tabbedPane.setBackground(SystemColor.activeCaption);
		tabbedPane.setAlignmentY(Component.TOP_ALIGNMENT);
		tabInformation = new JPanel();
		tabInformation.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, new Color(153, 180, 209), new Color(0, 0, 0), new Color(153, 180, 209)));
		tabInformation.setPreferredSize(new Dimension(425, 275));

		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");	
		
		LBL_LU = new JLabel("LU");
		LBL_LU.setFont(new Font("Arial", Font.BOLD, 12));
		
		lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		
		lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		
		GITHUB_LBL = new JLabel("Github URL");
		GITHUB_LBL.setFont(new Font("Arial", Font.BOLD, 12));
		
		CampoLU = new JTextField();
		CampoLU.setBorder(new LineBorder(Color.BLACK));
		CampoLU.setColumns(10);
		
		CampoApellido = new JTextField();
		CampoApellido.setBorder(new LineBorder(Color.BLACK));
		CampoApellido.setColumns(10);
		
		CampoNombre = new JTextField();
		CampoNombre.setBorder(new LineBorder(Color.BLACK));
		CampoNombre.setColumns(10);
		
		CampoEmail = new JTextField();
		CampoEmail.setBorder(new LineBorder(Color.BLACK));
		CampoEmail.setColumns(10);
		
		CampoGithub = new JTextField();
		CampoGithub.setBorder(new LineBorder(Color.BLACK));
		CampoGithub.setColumns(10);
		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_tabInformation.createSequentialGroup()
							.addComponent(LBL_LU)
							.addGap(58)
							.addComponent(CampoLU, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_tabInformation.createSequentialGroup()
							.addComponent(GITHUB_LBL)
							.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
							.addComponent(CampoGithub, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_tabInformation.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addComponent(CampoEmail, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_tabInformation.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
							.addComponent(CampoApellido, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_tabInformation.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
							.addComponent(CampoNombre, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(LBL_LU)
						.addComponent(CampoLU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(CampoApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(CampoNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(CampoEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(GITHUB_LBL)
						.addComponent(CampoGithub, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		tabInformation.setLayout(gl_tabInformation);
		tabbedPane.setBackgroundAt(0, SystemColor.window);
		contentPane.add(tabbedPane);
	}
}
