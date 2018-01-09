package cn.com.qxl.shiro.enums;


public enum FieldSysRolesPerm {

    FIELD_ROLE_ID("ROLE_ID","roleId"),//
    FIELD_PERMISSION_ID("PERMISSION_ID","permissionId"),//
    ;
    private String dbCode;
    private String attrCode;
    private FieldSysRolesPerm (String dbCode,String attrCode){
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