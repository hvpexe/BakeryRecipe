package dao;

import dto.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class CommentDAO {

    private static Connection conn = DBUtils.getConnection();
    private static final String SELECT_PROFILE_COMMENT_LIST
            = "  SELECT c.ID\n"
            + "	  ,c.RecipeID\n"
            + "	  ,c.UserID\n"
            + "  FROM [Comment] c \n"
            + "  WHERE c.UserID = ? and c.IsDeleted= 0\n"
            + "  Order By c.DateComment";

    public static List<Integer[]> getCommentList (int userid) {
        String sql = SELECT_PROFILE_COMMENT_LIST;
        List<Integer[]> list = new LinkedList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer[] cruID = {rs.getInt(1), rs.getInt(2), rs.getInt(3)};
                list.add(cruID);
            }
            return list;
        } catch (Exception e) {
            System.out.println("Get Comment List Error" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    private static final String SELECT_COMMENT_BY_ID = "SELECT [ID]\n"
            + "      ,[Comment]\n"
            + "      ,[DateComment]\n"
            + "      ,[LastDateEdit]\n"
            + "      ,[IsDeleted]\n"
            + "      ,[UserID]\n"
            + "      ,[RecipeID]\n"
            + "  FROM [Comment]"
            + "  WHERE ID = ?";

    public static Comment getCommentByID (int id) {
        String sql = SELECT_PROFILE_COMMENT_LIST;
        Comment comment = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                comment = new Comment(id, rs.getString(2), rs.getTimestamp(3),
                        rs.getTimestamp(4), rs.getBoolean(5),
                        rs.getInt(6), rs.getInt(7));
            return comment;
        } catch (Exception e) {
            System.out.println("Get Comment List Error" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
