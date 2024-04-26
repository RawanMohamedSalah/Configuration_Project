package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import database.DataAccessException;

public class AgentDaoImpl implements AgentDao {
    private DatabaseConnection dbConnection;

    public AgentDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Agent> getAllAgents() {
        List<Agent> agents = new ArrayList<>();
        String sql = "SELECT * FROM agents";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int agentId = rs.getInt("agent_id");
                String agentName = rs.getString("agent_name");
                String contactInformation = rs.getString("contact_information");
                String email = rs.getString("email");
                agents.add(new Agent(agentId, agentName, contactInformation, email));
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return agents;
    }

	@Override
	public List<Agent> getAllBooks() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}