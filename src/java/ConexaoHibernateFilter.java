
import exemplo2.conexao.HibernateUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author saimor
 */
public class ConexaoHibernateFilter implements Filter{
    private SessionFactory sf;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.sf = HibernateUtil.getSessionFactory();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            this.sf.getCurrentSession().beginTransaction();
            chain.doFilter(request, response);
            this.sf.getCurrentSession().getTransaction().commit();
            this.sf.getCurrentSession().close();
        } catch (Throwable ex){
            try{
                if(this.sf.getCurrentSession().getTransaction().isActive()){
                    this.sf.getCurrentSession().getTransaction().rollback();
                }
            } catch(Throwable t) {
                t.printStackTrace();
            }
            throw new ServletException(ex);
        }
    }

    @Override
    public void destroy() {
    }
    
    
}
