package asp4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Setup
        NotificationSystem notificationSystem = new NotificationSystem();
        NotificationSubscriber subscriber1 = new NotificationSubscriber("Subscriber 1");
        NotificationSubscriber subscriber2 = new NotificationSubscriber("Subscriber 2");

        notificationSystem.addObserver(subscriber1);
        notificationSystem.addObserver(subscriber2);

        NotificationContext context = new NotificationContext();

        Scanner scanner = new Scanner(System.in);

        // Interactive Program
        while (true) {
            System.out.println("Digite uma mensagem para notificação (ou 'exit' para sair): ");
            String message = scanner.nextLine();

            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Escolha a estratégia (1 para e-mail, 2 para SMS): ");
            int strategyChoice = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente

            switch (strategyChoice) {
                case 1:
                    context.setStrategy(new EmailNotificationStrategy());
                    break;
                case 2:
                    context.setStrategy(new SMSStrategy());
                    break;
                default:
                    System.out.println("Escolha inválida. Usando estratégia padrão.");
                    context.setStrategy(new EmailNotificationStrategy());
            }

            // Notificação usando Observer e Strategy
            notificationSystem.notifyObservers(message);
            context.executeStrategy(message);
        }

        System.out.println("Programa encerrado.");
    }
}