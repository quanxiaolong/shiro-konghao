package cn.com.qxl.shiro.enums;


public enum FieldSysUsers {

    FIELD_ID("ID","id"),//
    FIELD_USERNAME("USERNAME","username"),//
    FIELD_PASSWORD("PASSWORD","password"),//
    FIELD_SALT("SALT","salt"),//
    FIELD_LOCKED("LOCKED","locked"),//
    ;
    private String dbCode;
    private String attrCode;
    private FieldSysUsers (String dbCode,String attrCode){
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