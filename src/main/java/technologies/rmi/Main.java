package technologies.rmi;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
    public static final String UNIC_BINDING_NAME = "server.reverse";

    public static void main(String[] args) throws Exception
    {
        //создание объекта дл€ удаленного доступа
        final ReverseImpl service = new ReverseImpl();

        //создание реестра расшареных объектов
        final Registry registry = LocateRegistry.createRegistry(2099);
        //создание "заглушки" Ц приемника удаленных вызовов
        Remote stub = UnicastRemoteObject.exportObject(service, 0);
        //регистраци€ "заглушки" в реесте
        registry.bind(UNIC_BINDING_NAME, stub);

//усыпл€ем главный поток, иначе программа завершитс€
        Thread.sleep(Integer.MAX_VALUE);
    }
}
