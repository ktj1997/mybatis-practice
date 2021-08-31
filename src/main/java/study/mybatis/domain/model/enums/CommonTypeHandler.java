package study.mybatis.domain.model.enums;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonTypeHandler<E extends Enum<E>> implements TypeHandler<CodeEnum> {

    private Class<E> type;

    public CommonTypeHandler(Class<E> type) {
        this.type = type;
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, CodeEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getValue());
    }

    @Override
    public CodeEnum getResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return getCodeEnum(value);
    }

    @Override
    public CodeEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return getCodeEnum(value);
    }

    @Override
    public CodeEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return getCodeEnum(value);
    }

    private CodeEnum getCodeEnum(String value) {
        try {
            CodeEnum[] enumConstants = (CodeEnum[]) type.getEnumConstants();
            for (CodeEnum codeNum : enumConstants) {
                if (codeNum.getValue().equals(value)) {
                    return codeNum;
                }
            }
            return null;
        } catch (Exception e) {
            throw new TypeException("Can't make enum object '" + type + "'", e);
        }
    }
}
