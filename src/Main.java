import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Main {

    public static void main(String[] args) {
        // string de conexão e dados de acesso ao servidor
        String servidor = "jdbc:sqlserver://localhost:1433;databaseName=loja_de_automoveis";
        String usuario = "sa";
        String senha = "123";
        
        // conexão
        Connection conexao;
        // instrução SQL
        Statement instrucaoSQL;
        // resultados
        ResultSet resultados;
        
        try{
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(servidor, usuario, senha);
            
            // criando a instrução SQL
            instrucaoSQL = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultados = instrucaoSQL.executeQuery("SELECT * FROM carros");
            
            while (resultados.next()){
                int id = resultados.getInt("id");
                String nome = resultados.getString("nome");
                String modelo = resultados.getString("modelo");
                String motor = resultados.getString("motor");
                int anoFabricacao = resultados.getInt("anoFabricacao");
                int anoModelo = resultados.getInt("anoModelo");
                String cor = resultados.getString("cor");
                System.out.println("id: " + id);
                System.out.println("nome: " + nome);
                System.out.println("modelo: " + modelo);
                System.out.println("motor: " + motor);
                System.out.println("anoFabricacao: " + anoFabricacao);
                System.out.println("anoModelo: " + anoModelo);
                System.out.println("cor: " + cor);
                System.out.println("=============");
            }
        } catch (SQLException erro){
            System.out.println(erro.getMessage());
        }      
    } 
}
