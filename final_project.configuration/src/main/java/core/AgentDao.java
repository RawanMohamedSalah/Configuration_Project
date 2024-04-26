package core;
import java.util.List;

public interface AgentDao {
	List<Agent> getAllAgent() throws Exception;

	List<Agent> getAllAgents();
}