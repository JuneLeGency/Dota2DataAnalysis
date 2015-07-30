package studio.lc.dotaanalysis.dataservice.ISteamApps;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import studio.lc.dotaanalysis.dataservice.ISteamApps.dataBean.Applist;

import com.googlecode.androidannotations.annotations.rest.Get;
import com.googlecode.androidannotations.annotations.rest.Rest;

/**
 * General interfaces
 * @author legency
 *
 */
@Rest(rootUrl = "http://api.steampowered.com/ISteamApps", converters = { MappingJacksonHttpMessageConverter.class })
public interface ISteamAppsDP {
    @Get("/GetAppList/v2")
    Applist GetAppList();
}