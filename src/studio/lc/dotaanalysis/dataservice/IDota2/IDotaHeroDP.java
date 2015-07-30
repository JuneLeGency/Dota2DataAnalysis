package studio.lc.dotaanalysis.dataservice.IDota2;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import studio.lc.dotaanalysis.Constants;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.HerosResult;

import com.googlecode.androidannotations.annotations.rest.Get;
import com.googlecode.androidannotations.annotations.rest.Rest;

/**
 * General interfaces
 * 
 * @author legency
 * 
 */
@Rest(rootUrl = "http://api.steampowered.com/IEconDOTA2_", converters = { MappingJacksonHttpMessageConverter.class })
public interface IDotaHeroDP {
	@Get("{id}/GetHeroes/v1?key=" + Constants.APPkey + "&language={language}")
	HerosResult GetHeroes(int id, String language);
}