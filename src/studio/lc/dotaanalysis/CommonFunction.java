package studio.lc.dotaanalysis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.os.Environment;

import com.octo.android.robospice.SpiceManager;

public class CommonFunction {
	final static public  String getLanguage() {
		return Locale.getDefault().getLanguage();
	}

	public static String join(Object[] o, String flag) {
		StringBuffer str_buff = new StringBuffer();
		for (int i = 0, len = o.length; i < len; i++) {
			str_buff.append(String.valueOf(o[i]));
			if (i < len - 1)
				str_buff.append(flag);
		}
		return str_buff.toString();
	}

	public static Long acountidtosteamid(Long acount32bitid) {
		return acount32bitid + 76561197960265728l;
	}

	public static Long steamidtoacountid(Long steam64bitid) {
		return (steam64bitid - 76561197960265728l);
	}

	public static SpiceManager getSpiceManager(Context context) {
		Class<? extends Context> contextclass = context.getClass();
		SpiceManager manager = null;
		try {
			Method getSpicemethod = contextclass.getMethod("getSpiceManager");
			manager = (SpiceManager) getSpicemethod.invoke(context);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return manager;
	}

	public static Long steamidtoacountid(String steamId) {
		return steamidtoacountid(Long.valueOf(steamId));

	}

	public static Long getAccountid(SteamPrefs_ prefs_) {
		return steamidtoacountid(prefs_.steamId().get());
	}

	public static Long getAccountid(Context context) {
		return getAccountid(new SteamPrefs_(context));
	}

	public static void exportdb(Context context) {
		File database = context.getDatabasePath("dotasteam");
		File exportDir = new File(Environment.getExternalStorageDirectory(),
				"dbBackup");
		try {
			fileCopy(database, exportDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void fileCopy(File dbFile, File backup) throws IOException {
        FileChannel inChannel = new FileInputStream(dbFile).getChannel();
        FileChannel outChannel = new FileOutputStream(backup).getChannel();
        try {
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inChannel != null) {
                inChannel.close();
            }
            if (outChannel != null) {
                outChannel.close();
            }
        }
    }
	
	public static <T> List<T> CollectiontoList(Collection<T> c){
		if(c instanceof List){
			return (List<T>) c;
		}
		else{
			return new ArrayList<T>(c);
		}
	}
}
