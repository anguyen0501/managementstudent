/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonHoc;

import java.util.ArrayList;

/**
 *
 * @author Anonymous
 */
public interface IMonHocDAO {

    public ArrayList<MonHoc> getAll();

    public ArrayList<MonHoc> findIDMaMH(String maMH);

    public MonHoc addNew(MonHoc mh);

    public MonHoc updateByID(MonHoc mh);
   public ArrayList<MonHoc> CheckID(String mamh);
}
