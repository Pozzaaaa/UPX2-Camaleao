/*
 * Prof. Robson Martins
 * ADS/GTI Facens
 * POO / Classe para conexao JDBC com MySQL
 */

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
    
    private Connection conn;
    private Statement statement;
    private ResultSet resultSet;
    
    private String servidor;
    private String nomeDoBanco;
    private String usuario;
    private String senha;
    
    public MySQL(String nomeDoBanco,
                 String usuario, String senha){
        this.conn = null;
        this.servidor = "localhost:3306";
        this.nomeDoBanco = nomeDoBanco;
        this.usuario = usuario;
        this.senha = senha;
    }

    public MySQL(String servidor, String nomeDoBanco,
                 String usuario, String senha) {
        this.conn = null;
        this.servidor = servidor;
        this.nomeDoBanco = nomeDoBanco;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public boolean conectaBanco() {
        if (conn != null) {
            this.fechaBanco();
        }
        String connString = "jdbc:mysql://" + servidor + "/" + nomeDoBanco;
        try {
            conn = DriverManager.getConnection(connString, usuario, senha);
            if (conn != null) {
                return true;
            }            
        } catch (Exception e) {
            System.out.printf("Erro ao conectar com o banco de dados %s: %s\n",
                    connString, e.getMessage());
        }
        return false;
    }
    
    public boolean fechaBanco() {
        if (conn == null) {
            return true;
        }
        try {
            conn.close();
            conn = null;
            return true;
        } catch (Exception e) {
            System.out.printf("Erro ao desconectar do banco de dados: %s\n",
                    e.getMessage());
        }
        return false;
    }
    
    public boolean insert(String sql) {
        if (conn == null) {
            if (!conectaBanco()) return false;
        }
        try {
            this.statement = this.conn.createStatement();
            return this.statement.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            System.out.printf("Erro ao executar query '%s': %s\n",
                    sql, e.getMessage());
        }
        return false;
    }

    public boolean update(String sql) {
        return this.insert(sql);
    }

    public boolean delete(String sql) {
        return this.insert(sql);
    }
    
    public ResultSet select(String sql) {
        if (conn == null) {
            if (!conectaBanco()) return null;
        }
        try {
            this.statement = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            this.resultSet = this.statement.executeQuery(sql);
            return this.resultSet;
        } catch (SQLException e) {
            System.out.printf("Erro ao executar query '%s': %s\n",
                    sql, e.getMessage());
        }
        return null;
    }

    public String getServidor() {
        return servidor;
    }

    public String getNomeDoBanco() {
        return nomeDoBanco;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setServidor(String servidor) {
        if (servidor != null && servidor.equals(this.servidor)) return;
        fechaBanco();
        this.servidor = servidor;
    }

    public void setNomeDoBanco(String nomeDoBanco) {
        if (nomeDoBanco != null && nomeDoBanco.equals(this.nomeDoBanco)) return;
        fechaBanco();
        this.nomeDoBanco = nomeDoBanco;
    }

    public void setUsuario(String usuario) {
        if (usuario != null && usuario.equals(this.usuario)) return;
        fechaBanco();
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        if (senha != null && senha.equals(this.senha)) return;
        fechaBanco();
        this.senha = senha;
    }
   
    
}
