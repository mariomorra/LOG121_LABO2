package affichage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.FinalStrings;


public class ServerInput extends JFrame implements ActionListener{
	
	protected String hostname = "";
	protected int server = 0000;
	
	private JPanel panelInput = new JPanel();
	private JFrame frame = new JFrame("Entrée Serveur");
	private JLabel lblHostNameAndPort = new JLabel("Veuillez indiquer le nom de l'hote ainsi que le port du serveur de forme");
	private JTextField txtHostAndPort = new JTextField();
	private JPanel panelActions = new JPanel();
	private JLabel lblWarning = new JLabel("Format incorrect. (xxxx:0000)");
	private JButton buttonOK = new JButton("Ok");
	private JButton buttonCancel = new JButton("Annuler");
	
	public ServerInput() {	
		lblWarning.setForeground(Color.red);
		lblWarning.setVisible(false);
		
		panelInput.setLayout(new BoxLayout(panelInput, BoxLayout.PAGE_AXIS));
		panelInput.add(lblWarning);
		panelInput.add(lblHostNameAndPort);
		panelInput.add(txtHostAndPort);
		frame.add(panelInput, BorderLayout.NORTH);
		
		buttonOK.setActionCommand("Ok");
		buttonOK.setMnemonic(KeyEvent.VK_ENTER);
		buttonOK.addActionListener(this);
		buttonCancel.setActionCommand("Cancel");
		buttonCancel.setMnemonic(KeyEvent.VK_ESCAPE);
		buttonCancel.addActionListener(this);
		
		panelActions.add(buttonOK);
		panelActions.add(buttonCancel);
		frame.add(panelActions, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if("Ok".equals(e.getActionCommand())) {
			if(!this.txtHostAndPort.getText().isEmpty()){
				if(Pattern.compile(FinalStrings.HostNameAndServerRegex).matcher(this.txtHostAndPort.getText()).matches()){
					String[] HostAndServer = this.txtHostAndPort.getText().split(":");
					this.hostname = HostAndServer[0];
					this.server = Integer.parseInt(HostAndServer[1]);
					frame.setVisible(false);
					frame.dispose();
					ApplicationFormes application = new ApplicationFormes();
				} else{
					this.lblWarning.setVisible(true);
					this.frame.pack();
				}
			}
		} else {
			frame.setVisible(false);
			frame.dispose();
		}
	}

}
