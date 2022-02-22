
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
    
    @Override
    public void salvar(Usuario usuario){
        this.session.beginTransaction();
        this.session.saveOrUpdate(usuario);
        this.session.getTransaction().commit();
        
    }
    
    @Override
    public void atualizar(Usuario usuario){
        this.session.merge(usuario);
    }
    
    @Override
    public void excluir (Usuario usuario){
        this.session.delete(usuario);
    }

    @Override
    public Usuario carregar(Integer codigo){
        return (Usuario) this.session.get(Usuario.class, codigo);
    }
    
    @Override
    public Usuario buscarPorLogin(String login){
        String hql = "select u from Usuario u where u.login =:login";
        Query consulta = this.session.createQuery(hql);
        consulta.setString("login", login);
        
        return (Usuario) consulta.uniqueResult();
    }
    
    @Override
    public List<Usuario> listar(){
        this.session.beginTransaction();
        List<Usuario> lista = this.session.createCriteria(Usuario.class).list();
        return lista;
    }
}