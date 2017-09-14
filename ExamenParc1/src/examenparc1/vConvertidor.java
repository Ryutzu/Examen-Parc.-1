/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenparc1;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
/**
 *
 * @author Flores López Angel Raymundo
 */
public class vConvertidor extends JFrame implements ActionListener{
    JLabel _titu = new JLabel("Convertidor de pesos a dolares");
    JTextField _nums = new JTextField();
    JButton _con = new JButton("Convertir");
    JButton _lim = new JButton("Limpiar");
    JButton[] _bts = new JButton[11];
    
    /**
     * Metodo constructor para la ventana Swing del programa
     */
    public vConvertidor(){
        super("Convertidor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,700);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        Components();
    }
    /**
     * Metodo que inicializa los componentes de la ventana
     * Titulo
     * Texto
     * Botones
     */
    public void Components(){
        int cont=0;
        _titu.setBounds(200, 50, 400, 50);
        _nums.setBounds(150, 150, 400, 50);
        _nums.setEditable(false);
        add(_titu);
        add(_nums);
        for(int i=0;i<11;i++){
            _bts[i] = new JButton(""+(i+1)+"");
            _bts[i].addActionListener(this);
            if(i==9){
                _bts[i].setText("0");
            }else if(i==10){
                _bts[i].setText(".");
            }
            if(cont==3){
                cont=0;
            }
            int exe = 50*cont;
            if(i<3)
                _bts[i].setBounds((exe)+150,250, 50, 50);
            else if(i<6)
                _bts[i].setBounds((exe)+150,350, 50, 50);
            else if(i<9)
                _bts[i].setBounds((exe)+150,450, 50, 50);
            else
                _bts[i].setBounds((exe)+150,550, 50, 50);
            cont++;
            add(_bts[i]);
        }
        _con.setBounds(400, 250, 100, 50);
        _con.addActionListener(this);
        _lim.setBounds(400, 350, 100, 50);
        _lim.addActionListener(this);
        add(_con);
        add(_lim);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String num="";
        if(e.getSource()==_con){
            cConvertidor conv = new cConvertidor(_nums.getText());
            if(conv.getValor()!=0.0)
            _nums.setText(String.valueOf(conv.getValor()));
            else
                _nums.setText("Ingrese un numero valido menor a 8 digitos en unidades");
        }else if(e.getSource()==_lim){
            _nums.setText("");
        }else{
            for(int j=0;j<11;j++){
                if(e.getSource()==_bts[j]){
                    num=_bts[j].getText();
                }
            }
            _nums.setText(_nums.getText()+num);
        }
    }
    
}
