import java.rmi.Naming;
public class Client {
	public static void main(String[] args) {
		Ola obj = null;
		String msg = "minha mensagem";
		String retorno = null;
		try {
		obj = (Ola)Naming.lookup("//127.0.0.1/OlaServidor");
		retorno = obj.showMsg(msg);
		System.out.println(retorno);
		}
		catch (Exception e) {
		System.out.println("Client exception: " + e.getMessage());
		}
	}
}

