package VersionCompare;

import java.sql.Connection;
import java.sql.SQLException;

public interface IVersionCompareUtil {
	// 版本比較
	public int compareVersion(String version1, String version2);

	// 取得版本號
	public String getVerNumQuery(Connection conn, String sqlStr) throws SQLException;

	// 新增版本號
	public void addVerNum(Connection conn, String sqlStr, String verNumber) throws SQLException;
}
