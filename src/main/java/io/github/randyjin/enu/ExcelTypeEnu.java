package io.github.randyjin.enu;

public enum ExcelTypeEnu implements EnumInterface<ExcelTypeEnu> {
    EXCEL_2003(1,"excel2003"),
    EXCEL_2007(2,"excel2007"),
    MAC_NUMBER(3,"mac_number"),
    ;

    private int code;

    private String desc;

    ExcelTypeEnu(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public String getDesc() {
        return null;
    }

    public Integer getCode() {
        return null;
    }

    public ExcelTypeEnu getDefault() {
        return null;
    }
}
