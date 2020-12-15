package vn.vnpay.commons.database.manager;

import oracle.jdbc.OracleTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

public class DatabaseUtils {

    private static final Logger LOGGER = LogManager.getLogger(DatabaseUtils.class);

    public static CallableStatement buildPrepareCall(Connection con, String procedure, Object... parameters) {
        LOGGER.info("Begin execute procedure: {} with value: {}", procedure, parameters);
        CallableStatement cs = null;
        try {
            procedure = buildQuerry(procedure, parameters.length + 1);
            cs = con.prepareCall(procedure);
            setParameter(cs, parameters);
            cs.registerOutParameter(parameters.length + 1, OracleTypes.CURSOR);
        } catch (SQLException e) {
            LOGGER.error("Build prepare call have exception: {}", e);
        }
        return cs;
    }

    public static String buildQuerry(String procedure, int numberParam) {
        if (Strings.isEmpty(procedure) || numberParam < 0) return "";
        if (numberParam == 0) return new StringBuilder("{call ")
                .append(procedure)
                .append("()}")
                .toString();
        StringBuilder builder = new StringBuilder("{call ")
                .append(procedure)
                .append("(");

        for (int i = 0; i < numberParam; i++) {
            builder.append("?,");
        }
        builder.delete(builder.length() - 1, builder.length());
        builder.append(")}");
        LOGGER.info("Begin execute procedure: {}, and {} param", builder, numberParam);
        return builder.toString();
    }

    private static void setParameter(CallableStatement statement, Object... paraObjects) throws SQLException {
        for (int i = 0; i < paraObjects.length; i++) {
            Object parameter = paraObjects[i];
            int index = i + 1;
            if (parameter instanceof Long) {
                statement.setLong(index, (Long) parameter);

            } else if (parameter instanceof String) {
                statement.setString(index, (String) parameter);

            } else if (parameter instanceof Integer) {
                statement.setInt(index, (Integer) parameter);

            } else if (parameter instanceof Timestamp) {
                statement.setTimestamp(index, (Timestamp) parameter);

            } else if (parameter == null) {
                statement.setNull(index, Types.NULL);
            }
        }
    }
}
