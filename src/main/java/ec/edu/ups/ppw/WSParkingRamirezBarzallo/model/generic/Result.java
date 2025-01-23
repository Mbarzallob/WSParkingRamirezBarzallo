package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.generic;

public class Result <T>{

    private boolean success;
    private String message;
    private T data;
    public Result(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
    public static <T> Result<T> success(T data) {
        return new Result<T>(true, null, data);
    }

    public static <T> Result<T> failure(String message) {
        return new Result<T>(false, message, null);
    }

    public static <T> Result<T> ok() {
        return new Result<T>(true, null, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
