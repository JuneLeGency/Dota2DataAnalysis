package studio.lc.dotaanalysis.dataservice.ISteamUser;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import studio.lc.dotaanalysis.Constants;
import studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean.AppUsers;
import studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean.UsersProfile;

import com.googlecode.androidannotations.annotations.rest.Get;
import com.googlecode.androidannotations.annotations.rest.Rest;

@Rest(rootUrl = "http://api.steampowered.com/ISteamUser", converters = { MappingJacksonHttpMessageConverter.class })
public interface ISteamUserDP {

	@Get("/GetFriendList/v1?steamid={steamid}&relationship={relationship}&key="
			+ Constants.APPkey)
	AppUsers GetFriendList(String steamid, String relationship);
	
	@Get("/GetPlayerSummaries/v0002?steamids={steamids}&key="
			+ Constants.APPkey)
	UsersProfile GetPlayerSummaries(String steamids);
}