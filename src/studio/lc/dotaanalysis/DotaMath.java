package studio.lc.dotaanalysis;


public class DotaMath {
	public static int[] toByteArray(int iSource, int iArrayLen)
			throws Exception {
		int[] bLocalArr = new int[iArrayLen];
		int index = 0;
		while (iSource > 0) {
			if (index == iArrayLen) {
				throw new Exception(iArrayLen + "is not enough");
			}
			int a = iSource % 2;
			bLocalArr[index] = a;
			iSource = iSource / 2;
			index++;
		}
		return bLocalArr;
	}

	public static int toInt(int[] bRefArr) {
		int res = 0;
		for (int i = 0; i < bRefArr.length; i++) {
			res += bRefArr[i] * (int) Math.pow(2, (bRefArr.length - (i + 1)));
		}
		return res;
	}

	public static int[] toSlot(int solt) {
		int[] a = null;
		try {
			a = toByteArray(solt, 8);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	static public boolean isRadiant(int solt) {
		int[] a = toSlot(solt);
		return a[7] == 0;		
	}
	
	static public int getplayerposition(int solt) {
		int[] a = toSlot(solt);
		int[] n= new int[3];
		System.arraycopy(a, 0, n, 0, 3);
		return toInt(n);
	}
}
