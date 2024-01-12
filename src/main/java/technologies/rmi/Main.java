package technologies.rmi;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
    public static final String UNIC_BINDING_NAME = "server.reverse";

    public static void main(String[] args) throws Exception
    {
        //�������� ������� ��� ���������� �������
        final ReverseImpl service = new ReverseImpl();

        //�������� ������� ���������� ��������
        final Registry registry = LocateRegistry.createRegistry(2099);
        //�������� "��������" � ��������� ��������� �������
        Remote stub = UnicastRemoteObject.exportObject(service, 0);
        //����������� "��������" � ������
        registry.bind(UNIC_BINDING_NAME, stub);

//�������� ������� �����, ����� ��������� ����������
        Thread.sleep(Integer.MAX_VALUE);
    }
}
