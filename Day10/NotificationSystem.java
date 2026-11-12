interface Notification{
    void send(String message);
}

class EmailNotification implements Notification{
    public void send(String message){
        System.out.println("\nSending Email: " + message);
    }
}

class SMSNotification implements Notification{
    public void send(String message){
        System.out.println("Sending SMS: " + message);
    }
}

class WhatsAppNotification implements Notification{
    public void send(String message){
        System.out.println("Sending WhatsApp: " + message);
    }
}

class NotificationService{
    void notifyUser(String message, Notification notification){
        notification.send(message);
    }
}

class NotificationSystem{
    public static void main(String[] args){
        NotificationService notificationService = new NotificationService();
        Notification email = new EmailNotification();
        Notification sms = new SMSNotification();
        Notification whatsApp = new WhatsAppNotification();

        notificationService.notifyUser("Welcome to Java!", email);
        notificationService.notifyUser("Your OTP is 1234", sms);
        notificationService.notifyUser("You have a new message!", whatsApp);
    }
}