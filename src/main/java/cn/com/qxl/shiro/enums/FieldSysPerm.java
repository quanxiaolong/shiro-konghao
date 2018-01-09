package cn.com.qxl.shiro.enums;

public enum FieldSysPerm {

    FIELD_ID("ID","id"),//
    FIELD_PERMISSION("PERMISSION","permission"),//
    FIELD_URL("URL","url"),//
    FIELD_DESCRIPTION("DESCRIPTION","description"),//
    FIELD_AVAILABLE("AVAILABLE","available"),//
    ;
    private String dbCode;
    private String attrCode;
    private FieldSysPerm (String dbCode,String attrCode){
        this.dbCode = dbCode;
        this.attrCode = attrCode;
    }
    @Override
    public String toString(){
        return this.dbCode;
    }
    public String getAttrCode(){
        return this.attrCode;
    }
}