@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {
    SUCCESS(200,"成功"),
    FAIL(500, "失敗");

    private int code;
    private String desc;
}