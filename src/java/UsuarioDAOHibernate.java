
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author saimor
 */
public class UsuarioDAOHibernate implements UsuarioDAO{
    private Session session;
    
    public void setSession(Session session){
        this.session = session;
    }
    
    public void salvar(Usuario usuario){
        this.session.saveOrUpdate(usuario);
    }
    
    public void atualizar(Usuario usuario){
        this.session.merge(usuario);
    }
    
    public void excluir (Usuario usuario){
        this.session.delete(usuario);
    }

    public Usuario carregar(Integer codigo){
        return (Usuario) this.session.get(Usuario.class, codigo);
    }
    
    public Usuario buscarPorLogin(String login){
        String hql = "select u from Usuario u where u.login =:login";
        Query consulta = this.session.createQuery(hql);
        consulta.setString("login", login);
        
        return (Usuario) consulta.uniqueResult();
    }
    
    @SuppressWarnings("unchecked")
    public List<Usuario> listar(){
        return this.session.createCriteria(Usuario.class).list();
    }
}