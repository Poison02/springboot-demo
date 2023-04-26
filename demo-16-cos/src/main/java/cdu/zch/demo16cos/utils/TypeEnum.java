package cdu.zch.demo16cos.utils;

/**
 * @author Zch
 * @data 2023/4/26
 **/
public enum TypeEnum {

    ARCHIVE("archive");

    private String key;

    private TypeEnum(String key) {
        this.key = key;
    }

    private String getKey() {
        return key;
    }

    public static TypeEnum findByKey(String key) {
        if (key != null) {
            for (TypeEnum typeEnum: TypeEnum.values()) {
                if (key.equals(typeEnum.getKey())) {
                    return typeEnum;
                }
            }
        }
        return null;
    }

}
