/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo2.conexao;

import org.hibernate.Session;

/**
 *
 * @author saimor
 */
public class ConectarHibernateMySQL {
    public static void main(String[] args){
        Session sessao = null;
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            System.out.println("Conectou!");
        } finally{
            sessao.close();
        }
    }
}
