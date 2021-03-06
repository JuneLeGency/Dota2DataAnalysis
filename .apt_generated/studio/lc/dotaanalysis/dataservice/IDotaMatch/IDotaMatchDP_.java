//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package studio.lc.dotaanalysis.dataservice.IDotaMatch;

import java.util.HashMap;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.MatchDetail;

public class IDotaMatchDP_
    implements IDotaMatchDP
{

    private RestTemplate restTemplate;
    private String rootUrl;

    public IDotaMatchDP_() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        rootUrl = "http://api.steampowered.com/IDOTA2Match_";
    }

    @Override
    public MatchHistory GetMatchHistory(int id, String player_name, String account_id) {
        HashMap<String, Object> urlVariables = new HashMap<String, Object>();
        urlVariables.put("id", id);
        urlVariables.put("player_name", player_name);
        urlVariables.put("account_id", account_id);
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);
        return restTemplate.exchange(rootUrl.concat("{id}/GetMatchHistory/v1?key=D9F210C67C52FCE7C25B86441C9ED2EA&player_name={player_name}&account_id={account_id}"), HttpMethod.GET, requestEntity, MatchHistory.class, urlVariables).getBody();
    }

    @Override
    public MatchHistory GetMatchHistoryBySequenceNum(int id, String start_at_match_seq_num, String matches_requested) {
        HashMap<String, Object> urlVariables = new HashMap<String, Object>();
        urlVariables.put("id", id);
        urlVariables.put("start_at_match_seq_num", start_at_match_seq_num);
        urlVariables.put("matches_requested", matches_requested);
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);
        return restTemplate.exchange(rootUrl.concat("{id}GetMatchHistoryBySequenceNum/v1?key=D9F210C67C52FCE7C25B86441C9ED2EA&start_at_match_seq_num={start_at_match_seq_num}&matches_requested={matches_requested}"), HttpMethod.GET, requestEntity, MatchHistory.class, urlVariables).getBody();
    }

    @Override
    public MatchDetail GetMatchDetails(int id, String match_id) {
        HashMap<String, Object> urlVariables = new HashMap<String, Object>();
        urlVariables.put("id", id);
        urlVariables.put("match_id", match_id);
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);
        return restTemplate.exchange(rootUrl.concat("{id}/GetMatchDetails/v1?key=D9F210C67C52FCE7C25B86441C9ED2EA&match_id={match_id}"), HttpMethod.GET, requestEntity, MatchDetail.class, urlVariables).getBody();
    }

}
