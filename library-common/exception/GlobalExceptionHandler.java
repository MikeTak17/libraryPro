@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public Result handler(BaseException e){
        if (e.getCode() != null){
            return Result.error(e.getMessage());
        }
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handleValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null){
                message = fieldError.getField() + fieldError.getDefaultMessage();
            }
        }
        return Result.error(message);
    }

    @ExceptionHandler(value = BindException.class)
    public Result handleValidException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResul.getFieldError();
            if (fieldError != null){
                message = fieldError.getField() + fieldError.getDefaultMessage();
            }
        }
        return Result.error(message);
    }
}