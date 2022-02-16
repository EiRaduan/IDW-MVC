
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author saimor
 */

@Named
@RequestScoped

public class UsuarioBean {
    private Usuario usuario = new Usuario();
    private String confirmarSenha;

    
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getConfirmarSenha() {
        return this.confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
    
    public String novo(){
        this.usuario = new Usuario();
        this.usuario.setAtivo(true);
        return "usuario";
    }
    
    public String salvar(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        String senha = this.usuario.getSenha();
        if(!senha.equals(this.confirmarSenha)){
            FacesMessage facesMessage = new FacesMessage("A senha não foi confirmada corretamente");
            context.addMessage(null, facesMessage);
            return null;
        }
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.salvar(this.usuario);
        
        return "usuarioSucesso";
    }
    
}
