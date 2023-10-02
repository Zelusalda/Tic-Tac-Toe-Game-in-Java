/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogovelha;
import javax.swing.*;
/**
 *
 * @author FATS99879
 */
public class operacao {       
    String[] cam = new String[10];
    String simb;
    int conjog, nvX=0, nvO=0, nE=0;
    
    public void inicializar(){
        for (int x=0;x<10;x++){
            cam[x]="";            
        }
        simb="X";
        conjog=0;
    }    
    
    //Permite atribuir símbolos da jogada aos botões
    public String jogada(JButton b){         
        if ((b.getText().equals(""))){
            if ((simb.equals("X"))){
                simb="O";                
            }else if((simb.equals("O"))){
                simb="X";
            }
            conjog++;
            armjogada(b,simb);            
            return simb;            
        } 
        return b.getText();
    } 
    
    /* Caminhos para vitória
    
       C1 = b1,b2,b3
       C2 = b4,b5,b6
       C3 = b7,b8,b9
       C4 = b1,b4,b7
       C5 = b2,b5,b8
       C6 = b3,b6,b9
       C7 = b1,b5,b9
       C8 = b3,b5,b7
    */
    
    public void armjogada(JButton b,String simb){        
        if(b.getName().equals("b1")){
            cam[1]=cam[1]+simb;
            cam[4]=cam[4]+simb;
            cam[7]=cam[7]+simb;            
        }else if(b.getName().equals("b2")){
            cam[1]=cam[1]+simb;
            cam[5]=cam[5]+simb;            
        }else if(b.getName().equals("b3")){
            cam[1]=cam[1]+simb;            
            cam[6]=cam[6]+simb;
            cam[8]=cam[8]+simb;              
        }else if(b.getName().equals("b4")){
            cam[2]=cam[2]+simb;            
            cam[4]=cam[4]+simb;                          
        }else if(b.getName().equals("b5")){
            cam[2]=cam[2]+simb;            
            cam[5]=cam[5]+simb;
            cam[7]=cam[7]+simb;
            cam[8]=cam[8]+simb; 
        }else if(b.getName().equals("b6")){
            cam[2]=cam[2]+simb;            
            cam[6]=cam[6]+simb;                          
        }else if(b.getName().equals("b7")){
            cam[3]=cam[3]+simb;            
            cam[4]=cam[4]+simb;
            cam[8]=cam[8]+simb;              
        }else if(b.getName().equals("b8")){
            cam[3]=cam[3]+simb;            
            cam[5]=cam[5]+simb;                       
        }else if(b.getName().equals("b9")){
            cam[3]=cam[3]+simb;            
            cam[6]=cam[6]+simb;
            cam[7]=cam[7]+simb;              
        }
    }
    
    public boolean triunfo(JLabel visorO, JLabel visorX, JLabel visorE){
        boolean en=false;
        int x=1;       
        if ((conjog>0)&&(conjog<10)){
            while((x<10)&&(en==false)){
                if (cam[x].equals("XXX")||cam[x].equals("OOO")){                    
                    JOptionPane.showMessageDialog(null, "Parabéns pelo triunfo "+cam[x].substring(0,1), "Aviso", 1);
                    en=true;                      
                    if (cam[x].substring(0,1).equals("O")){
                        nvO++;
                        visorO.setText("O jogador O tem "+nvO+" triunfo");                
                    }else{
                        nvX++;
                        visorX.setText("O jogador X tem "+nvX+" triunfo");               
                    }                    
                }
                x++;
            }
            if((en==false)&&(conjog==9)){                
                JOptionPane.showMessageDialog(null, "O jogo empatou", "Aviso", 1);    
                nE++;
                visorE.setText("Houve "+nE+" empate(s)");  
            }   
        }          
        return en;
    }
}
