/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.util.ArrayList;

public class Totalidad_De_Grupos {
    private ArrayList<Grupo> grupos ;

    public Totalidad_De_Grupos() {
        grupos=new ArrayList<Grupo>();
    }
    public void insert(Grupo g){grupos.add(g);}
    
    public String toHTML(){
        int tdCant=2;
        int conttd=2;
        StringBuilder r = new StringBuilder();
        
        for (int i=0;i< grupos.size();i++){
            if(conttd==tdCant){
                r.append("<tr>");
                r.append("<td>");
                r.append(grupos.get(i).toHTML());
                r.append("</td>");
                
                conttd=1;
            }
            else{
                r.append("<td>");
                r.append(grupos.get(i).toHTML());
                r.append("</td>");
                r.append("</tr>");
                conttd++;
            }
            
            
        }
        return r.toString();
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }
    
}
