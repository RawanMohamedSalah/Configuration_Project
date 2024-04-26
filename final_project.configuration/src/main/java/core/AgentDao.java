package core;
import java.util.List;

public interface AgentDao {
	List<Agent> getAllBooks() throws Exception;

	List<Agent> getAllAgents();
}