package MockitoExercises.HandlingVoidMethods;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void notifyUser(String message) {
        api.sendNotification(message);
    }
}