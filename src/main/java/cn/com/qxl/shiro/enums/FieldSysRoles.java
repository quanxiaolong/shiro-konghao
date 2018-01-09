package cn.com.qxl.shiro.enums;

public enum FieldSysRoles {

    FIELD_ID("ID","id"),//
    FIELD_ROLE("ROLE","role"),//
    FIELD_DESCRIPTION("DESCRIPTION","description"),//
    FIELD_AVAILABLE("AVAILABLE","available"),//
    ;
    private String dbCode;
    private String attrCode;
    private FieldSysRoles (String dbCode,String attrCode){
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