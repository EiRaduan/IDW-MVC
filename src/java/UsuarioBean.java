
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
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
    private List<Usuario> lista;

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    public String getDestinoSalvar() {
        return destinoSalvar;
    }

    public void setDestinoSalvar(String destinoSalvar) {
        this.destinoSalvar = destinoSalvar;
    }
    private String destinoSalvar;

    
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
        this.destinoSalvar = "usuarioSucesso";
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
        
        return this.destinoSalvar;
    }
    
    public List<Usuario> getList(){
        if(this.lista == null){
            UsuarioRN usuarioRN = new UsuarioRN();
            this.lista = usuarioRN.listar();
        }
        return this.lista;
    }
    
   public String editar(){
       this.confirmarSenha = this.usuario.getSenha();
       return "/Publico/usuario";
   }
   
   public String excluir(){
       UsuarioRN usuarioRN = new UsuarioRN();
       usuarioRN.excluir(this.usuario);
       this.lista = null;
       return null;
   }
   
   public String ativar(){
       if(this.usuario.isAtivo()){
           this.usuario.setAtivo(false);
       } else {
           this.usuario.setAtivo(true);
       }
       
       UsuarioRN usuarioRN = new UsuarioRN();
       usuarioRN.salvar(this.usuario);
       return null;
   }
    
}
