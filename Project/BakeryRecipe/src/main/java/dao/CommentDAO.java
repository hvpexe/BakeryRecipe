package dao;

import dto.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            + "  Order By c.DateComment DESC";

    public static List<Integer[]> getCommentList (int userid) throws SQLException {
        String sql = SELECT_PROFILE_COMMENT_LIST;
        List<Integer[]> list = new LinkedList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
        conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userid);
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer[] cruID = {rs.getInt(1), rs.getInt(2), rs.getInt(3)};
                list.add(cruID);
            }
            return list;
        } catch (Exception e) {
            System.out.println("Get Comment List Error" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }
    private static final String SELECT_COMMENT_BY_ID
            = "SELECT [ID]\n"
            + "      ,[Comment]\n"
            + "      ,[DateComment]\n"
            + "      ,[LastDateEdit]\n"
            + "      ,[IsDeleted]\n"
            + "      ,[UserID]\n"
            + "      ,[RecipeID]\n"
            + "  FROM [Comment]"
            + "  WHERE ID = ?";

    public static Comment getCommentByID (int id) throws SQLException {
        String sql = SELECT_COMMENT_BY_ID;
        Comment comment = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
           Connection conn = null;    
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                comment = new Comment(id, rs.getString(2), rs.getTimestamp(3),
                        rs.getTimestamp(4), rs.getBoolean(5),
                        rs.getInt(6), rs.getInt(7));
            }
            return comment;
        } catch (Exception e) {
            System.out.println("Get Comment List Error" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    private static final String MANAGE_COMMENT_LIST = "SELECT [Comment].ID, [Comment].Comment, "
            + "[Comment].DateComment, [Comment].LastDateEdit, "
            + "[User].Avatar, [User].FirstName + ' ' + [User].LastName AS [Username], "
            + "[User].ID AS [UserID], [Recipe].ID AS [RecipeID], "
            + "[Recipe].[Name] AS [RecipeName], [Comment].IsDeleted\n"
            + "FROM [Comment]\n"
            + "JOIN [Recipe] ON [Comment].RecipeID = [Recipe].ID\n"
            + "JOIN [User] ON [Comment].UserID = [User].ID\n"
            + "WHERE [Comment].IsDeleted = 0;";

    public static List<Comment> manageCommentList () throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareCall(MANAGE_COMMENT_LIST);
            rs = ps.executeQuery();
            List<Comment> list = new ArrayList<>();
            while (rs.next()) {
                Comment comment = new Comment(rs.getInt("ID"),
                        rs.getString("Comment"),
                        rs.getTimestamp("DateComment"),
                        rs.getTimestamp("LastDateEdit"),
                        rs.getBoolean("IsDeleted"),
                        rs.getInt("UserID"),
                        rs.getInt("RecipeID"),
                        rs.getString("Avatar"),
                        rs.getString("Username"),
                        rs.getString("RecipeName"));
                list.add(comment);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("CommentList Query Error!" + ex.
                    getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    private static final String UPDATE_DELETE = "UPDATE Comment\n"
            + "            SET IsDeleted = 1\n"
            + "            WHERE Comment.[ID] = ?";

    public static boolean deleteComment (int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(UPDATE_DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Query Delete Comment For User error!" + ex.getMessage());
        } finally {

            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }
}
