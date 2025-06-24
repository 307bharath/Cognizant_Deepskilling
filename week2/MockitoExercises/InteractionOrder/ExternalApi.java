package MockitoExercises.InteractionOrder;

public interface ExternalApi {
    void connect();
    String getData();
    void disconnect();
}