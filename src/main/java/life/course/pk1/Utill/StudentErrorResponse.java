package life.course.pk1.Utill;

public class StudentErrorResponse {
    private String message;
    private long timestamp;

    public StudentErrorResponse(String message, long timestamp){
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
