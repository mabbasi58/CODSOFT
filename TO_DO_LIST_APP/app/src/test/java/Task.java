public class Task {
    private String title;
    private String description;
    private boolean isComplete;

    // Constructor
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.isComplete = false; // By default, a new task is not complete
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
