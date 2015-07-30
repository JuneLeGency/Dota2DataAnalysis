package studio.lc.dotaanalysis.service;

import java.util.ArrayList;
import java.util.List;

import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Hero;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Heros;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.Ability;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.BanPick;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.DotaPlayer;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.Match;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.MatchResult;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.Unit;
import android.app.Application;

import com.octo.android.robospice.SpiceService;
import com.octo.android.robospice.persistence.CacheManager;
import com.octo.android.robospice.persistence.exception.CacheCreationException;
import com.octo.android.robospice.persistence.ormlite.InDatabaseObjectPersisterFactory;
import com.octo.android.robospice.persistence.ormlite.RoboSpiceDatabaseHelper;
import com.octo.android.robospice.persistence.springandroid.json.jackson.JacksonObjectPersisterFactory;

/**
 * Simple service
 * @author sni
 */
public class SampleSpiceService extends SpiceService {

    @Override
    public CacheManager createCacheManager(Application application) throws CacheCreationException {
        CacheManager cacheManager = new CacheManager();
        JacksonObjectPersisterFactory jacksonObjectPersisterFactory = new JacksonObjectPersisterFactory( application );
        List< Class< ? >> classCollection = new ArrayList< Class< ? >>();

        // add persisted classes to class collection
        classCollection.add( Hero.class );
        classCollection.add( Heros.class );
        classCollection.add( MatchResult.class );
        classCollection.add( Match.class );
        classCollection.add( DotaPlayer.class );
        classCollection.add( BanPick.class );
        classCollection.add( Ability.class );
        classCollection.add( Unit.class );

        // init
        RoboSpiceDatabaseHelper databaseHelper = new RoboSpiceDatabaseHelper( application, "dotasteam", 1 );
        InDatabaseObjectPersisterFactory inDatabaseObjectPersisterFactory = new InDatabaseObjectPersisterFactory( application, databaseHelper, classCollection );
        cacheManager.addPersister( inDatabaseObjectPersisterFactory );
        cacheManager.addPersister( jacksonObjectPersisterFactory );
        return cacheManager;
    }

    @Override
    public int getThreadCount() {
        return 3;
    }
}
