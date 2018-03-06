package banco.univel.rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import banco.univel.rmi.remotebase.IRemoteBancoUnivel;

public class Client1 {
	public static void main(String[] args) {
		System.out.println("Registrando no servidor remoto...");
		
		try {
			Registry registry = LocateRegistry.getRegistry(9876);
			
			IRemoteBancoUnivel stub = (IRemoteBancoUnivel)registry.lookup("servidor_banco_univel");
			
			stub.deposito(1, 100);
			stub.saque(1, 20);
			double saldo = stub.saldo(1);
			System.out.println("Saldo: " + saldo);
			
			stub.deposito(2, 300);
			stub.saque(2, 100);
			saldo = stub.saldo(2);
			System.out.println("Saldo: " + saldo);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
