@Data
public class BasePage implements Serializable{
    private static final long serialVersionUID = -2560796196204101092L;

    /*每頁顯示的資料筆數， 預設為10*/
    /*protected代表: 父類可以給子類存取，但不能被其他類別使用*/
    protected long size = 10;

    /*當前頁， 預設為1*/
    protected long current = 1;
}