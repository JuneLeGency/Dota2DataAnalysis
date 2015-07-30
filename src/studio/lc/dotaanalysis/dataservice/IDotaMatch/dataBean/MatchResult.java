package studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean;

import java.util.Collection;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author legency
 * 
 */
@DatabaseTable(tableName = "matchresult")
public class MatchResult {
	@DatabaseField(generatedId = true)
	private int id;

	/**
	 * 1 - Success 8 - 'matches_requested' must be greater than 0. 15 - Cannot
	 * get match history for a user that hasn't allowed it.
	 * 
	 */
	@DatabaseField
	private int status;
	/**
	 * A message explaining the status, should status not be 1.
	 * 
	 */
	@DatabaseField
	private String statusDetail;
	/**
	 * The number of matches in this response.
	 * 
	 */
	@DatabaseField
	private int num_results;

	/**
	 * 
	 The total number of matches for the query.
	 */
	@DatabaseField
	private int total_results;
	/**
	 * The number of matches left for this query.
	 * 
	 */
	@DatabaseField
	private int results_remaining;

	@ForeignCollectionField(eager=true)
	Collection<Match> matches;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusDetail() {
		return statusDetail;
	}

	public void setStatusDetail(String statusDetail) {
		this.statusDetail = statusDetail;
	}

	public int getNum_results() {
		return num_results;
	}

	public void setNum_results(int num_results) {
		this.num_results = num_results;
	}

	public int getTotal_results() {
		return total_results;
	}

	public void setTotal_results(int total_results) {
		this.total_results = total_results;
	}

	public int getResults_remaining() {
		return results_remaining;
	}

	public void setResults_remaining(int results_remaining) {
		this.results_remaining = results_remaining;
	}

	public Collection<Match> getMatches() {
		return matches;
	}

	public void setMatches(Collection<Match> matches) {
		this.matches = matches;
	}

}
