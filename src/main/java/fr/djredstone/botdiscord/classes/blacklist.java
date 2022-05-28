package fr.djredstone.botdiscord.classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.dv8tion.jda.api.entities.User;

import fr.djredstone.botdiscord.Utils;

public class blacklist {

    public static boolean add(User user) throws SQLException {
        if (!contains(user)) {

            final PreparedStatement preparedStatement1 = Utils.createPreparedStatement("INSERT INTO ALLCRAFT0R_blacklist VALUES ( ? )");
            preparedStatement1.setString(1, user.getId());

            preparedStatement1.executeUpdate();
            return true;

        }
        return false;
    }

    public static boolean remove(User user) throws SQLException {
        if (contains(user)) {

            final PreparedStatement preparedStatement1 = Utils.createPreparedStatement("DELETE FROM ALLCRAFT0R_blacklist WHERE ?");
            preparedStatement1.setString(1, user.getId());

            preparedStatement1.executeUpdate();
            return true;

        }
        return false;
    }

    public static boolean contains(User user) throws SQLException {
        final PreparedStatement preparedStatement = Utils.createPreparedStatement("SELECT * FROM ALLCRAFT0R_blacklist WHERE uuid = ?");
        preparedStatement.setString(1, user.getId());
        final ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

}