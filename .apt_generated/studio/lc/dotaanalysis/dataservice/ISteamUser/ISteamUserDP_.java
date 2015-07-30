//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package studio.lc.dotaanalysis.dataservice.ISteamUser;

import java.util.HashMap;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean.AppUsers;
import studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean.UsersProfile;

public class ISteamUserDP_
    implements ISteamUserDP
{

    private RestTemplate restTemplate;
    private String rootUrl;

    public ISteamUserDP_() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        rootUrl = "http://api.steampowered.com/ISteamUser";
    }

    @Override
    public UsersProfile GetPlayerSummaries(String steamids) {
        HashMap<String, Object> urlVariables = new HashMap<String, Object>();
        urlVariables.put("steamids", steamids);
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);
        return restTemplate.exchange(rootUrl.concat("/GetPlayerSummaries/v0002?steamids={steamids}&key=D9F210C67C52FCE7C25B86441C9ED2EA"), HttpMethod.GET, requestEntity, UsersProfile.class, urlVariables).getBody();
    }

    @Override
    public AppUsers GetFriendList(String steamid, String relationship) {
        HashMap<String, Object> urlVariables = new HashMap<String, Object>();
        urlVariables.put("steamid", steamid);
        urlVariables.put("relationship", relationship);
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);
        return restTemplate.exchange(rootUrl.concat("/GetFriendList/v1?steamid={steamid}&relationship={relationship}&key=D9F210C67C52FCE7C25B86441C9ED2EA"), HttpMethod.GET, requestEntity, AppUsers.class, urlVariables).getBody();
    }

}
