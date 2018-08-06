package bidReport.enums;

/**
 * Created by pc-mg on 7/25/2018.
 */
public enum OwnerEnum {
    OWNER_NAME("MLINOGRADNJA doo Kac"),
    OWNER_ACCOUNT("Tek.racun.br: 340-11007701-89 ERSTE BANKA Novi Sad"),
    OWNER_PIB("107447278"),
    OWNER_PHONE("0216210006"),
    OWNER_CELL_PHONE("0641182292"),
    OWNER_EMAIL("momirmirkovic@yahoo.com"),
    OWNER_ADDRESS("Slavka Rodica 37 21241 Kac");



    private final String content;

    OwnerEnum(String content) {
        this.content = content;
    }

    public String getContent(){
        return content;
    }
}
