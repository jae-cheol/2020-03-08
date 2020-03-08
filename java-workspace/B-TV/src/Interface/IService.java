package Interface;
import java.util.List;
public interface IService<T> {
	public default T checkLogin(String id, String pass) throws Exception {return null;}
	public default boolean checkID(String id){return false;};
	public abstract void insertBoard(T login);
	public abstract List<T> selectBoard() throws Exception;
	public abstract T selectOneBoard(T login);
}
