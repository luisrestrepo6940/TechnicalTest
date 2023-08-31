package co.com.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumVariablesSesion {

    SESSION_PRODUCT_ONE("productOne"),
    SESSION_PRODUCT_TWO("productTwo");
    private final String value;

}
