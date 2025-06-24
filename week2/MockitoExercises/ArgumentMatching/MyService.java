package MockitoExercises.ArgumentMatching;


public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String processData(String input) {
        return api.getData(input);
    }
}
