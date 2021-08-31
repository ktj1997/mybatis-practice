package study.mybatis.domain.model.enums;

import lombok.Getter;
import org.apache.ibatis.type.MappedTypes;

@Getter
public enum Gender implements CodeEnum {
    MALE("M"), FEMALE("F");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    @MappedTypes(Gender.class)
    public static class TypeHandler extends CommonTypeHandler<Gender> {
        public TypeHandler() {
            super(Gender.class);
        }
    }
}
