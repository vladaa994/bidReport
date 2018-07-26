package bidReport.enums;

/**
 * Created by pc-mg on 7/25/2018.
 */
public enum OwnerEnum {
    ownerName("MLINOGRADNJA doo Kac"),
    ownerAccount("Tek.racun.br: 340-11007701-89 ERSTE BANKA Novi Sad"),
    ownerPIB("107447278"),
    ownerPhone("021-6210-006"),
    ownerCellPhone("064-11-8-22-92"),
    ownerEmail("momirmirkovic@yahoo.com"),
    ownerAddress("Slavka Rodica 37 21241 Kac");



    private final String content;

    OwnerEnum(String content) {
        this.content = content;
    }

    public String getContent(){
        return content;
    }
}
