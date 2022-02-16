
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author saimor
 */
public interface UsuarioDAO {
    public void salvar(Usuario usuario);
    public void atualizar(Usuario usuario);
    public void excluir(Usuario usuario);
    public Usuario carregar(Integer codigo);
    public Usuario buscarPorLogin(String login);
    public List<Usuario> listar();
}
