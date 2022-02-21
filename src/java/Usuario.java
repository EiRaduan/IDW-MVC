
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.NaturalId;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author saimor
 */
@Entity
@Table(name = "usuario")
public class Usuario implements  Serializable{
   @Id
   @GeneratedValue
   private Integer codigo;
   private String nome;
   private String email;
   @NaturalId
   private String login;
   private String senha;
   private Date nascimento;
   private String celular;
   private boolean ativo;
   
   @ElementCollection(targetClass = String.class)
   @JoinTable(
           name = "usuario_permissao",
           uniqueConstraints = {
               @UniqueConstraint(columnNames = {"usuario", "permissao"})},
            joinColumns = @JoinColumn(name = "usuario"))
    @Column(name = "permissao", length = 50)
    private Set<String> permissao = new HashSet<String>();

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }


    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Set<String> getPermissao() {
        return permissao;
    }

    public void setPermissao(Set<String> permissao) {
        this.permissao = permissao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.codigo);
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.login);
        hash = 37 * hash + Objects.hashCode(this.senha);
        hash = 37 * hash + Objects.hashCode(this.nascimento);
        hash = 37 * hash + Objects.hashCode(this.celular);
        hash = 37 * hash + (this.ativo ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.permissao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.celular, other.celular)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        return Objects.equals(this.permissao, other.permissao);
    }
   

    
   
}
