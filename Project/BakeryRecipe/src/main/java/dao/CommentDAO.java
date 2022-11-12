package dao;

import dto.Comment;
import dto.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
        User baker = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                comment = new Comment(id, rs.getString(2), rs.getTimestamp(3),
                        rs.getTimestamp(4), rs.getBoolean(5),
                        rs.getInt(6), rs.getInt(7));
                baker =UserDAO.getUserByID(rs.getInt("UserID"));
                comment.setAvatar(baker.getAvatar());
                comment.setChefName(baker.getName());
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
    private static final String SELECT_LIST = "SELECT [ID]\n"
            + "      ,[Comment]\n"
            + "      ,[DateComment]\n"
            + "      ,[LastDateEdit]\n"
            + "      ,[IsDeleted]\n"
            + "      ,[UserID]\n"
            + "      ,[RecipeID]\n"
            + "  FROM [Comment]";

    public static List<Comment> getCommentedUserFromRecipe (int recipeID) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Comment> list = new LinkedList<>();

        try {
            String sql = SELECT_LIST + "WHERE RecipeID = ? AND IsDeleted=0";
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, recipeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Comment cmt = new Comment(rs.getInt(1), rs.getString(2), rs.getTimestamp(3),
                        rs.getTimestamp(4), rs.getBoolean(5),
                        rs.getInt(6), recipeID);
                User user = UserDAO.getUserByID(cmt.getUserID());
                cmt.setAvatar(user.getAvatar());
                cmt.setChefName(user.getName());
                list.add(cmt);
            }
            return list;
        } catch (Exception ex) {
            System.out.println("Query Delete Comment For User error!" + ex.getMessage());
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
    private static final String findbyDate = "SELECT ID\n"
            + "FROM [dbo].[Comment]\n"
            + "WHERE [DateComment] =?";

    public static int commentByDate (Timestamp date) throws SQLException {
        Connection cn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        int cmtID = 0;
        String thevalue = null;
        long timead = date.getTime();
        try {
            cn = DBUtils.getConnection();
            ptm = cn.prepareStatement(findbyDate);
            ptm.setLong(1, date.getTime());
            rs = ptm.executeQuery();
            while (rs.next()) {
//                cmtID   =Integer.parseInt(rs.getString("ID")) ;
                thevalue = rs.getString("ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return cmtID;
    }
    private static final String CMT_RECIPE
            = "INSERT INTO [dbo].[Comment]([Comment],[DateComment],[LastDateEdit],[IsDeleted],[UserID],[RecipeID])\n"
            + " VALUES (?,?,?,?,?,?)";

    public static Integer commentRecipe (String comment, int UserID, int RecipeID) throws SQLException {
        Connection cnn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        //        Timestamp date = new Timestamp(System.currentTimeMillis());Date currentDate = new Date (1665559539000)
        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        boolean check = false;
        try {
            cnn = DBUtils.getConnection();
            ptm = cnn.prepareStatement(CMT_RECIPE);
            ptm.setString(1, comment);
            ptm.setTimestamp(2, currentDate);
            ptm.setTimestamp(3, currentDate);
            ptm.setBoolean(4, false);
            ptm.setInt(5, UserID);
            ptm.setInt(6, RecipeID);
            check = ptm.executeUpdate() > 0 ? true : false;
            if (check) {
                return GetNewestCommentID(UserID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
        return null;
    }
    private static final String LIST_COMMENT
            = "select  baker.LastName+' ' +baker.FirstName  as fullName ,DateComment,cmt.ID,cmt.Comment,baker.Avatar,cmt.UserID\n"
            + " from [dbo].[Comment] cmt join [dbo].[User] baker\n"
            + " on cmt.UserID = baker.ID\n"
            + "            where cmt.RecipeID = ?"
            + "            ORDER BY DateComment Desc ";

    public static List<Comment> commentList (int recipeID) throws SQLException {
        List<Comment> cmtList = new ArrayList<>();
        Connection cnn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            cnn = DBUtils.getConnection();
            ptm = cnn.prepareStatement(LIST_COMMENT);
            ptm.setInt(1, recipeID);
            rs = ptm.executeQuery();
            while (rs.next()) {
                int commentID = rs.getInt("ID");
                String avatar = rs.getString("Avatar");
                String comment = rs.getString("Comment");
                String name = rs.getString("fullName");
                Timestamp dateComment = rs.getTimestamp("DateComment");
                Comment cmt = new Comment(commentID, comment, dateComment, avatar, name);
                cmt.setUserID(rs.getInt("UserID"));
                cmtList.add(cmt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
        return cmtList;
    }

    public static Integer GetNewestCommentID (int userID) throws SQLException {
        String sql = "select max(ID) as ID from Comment";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Get Newest CommentID Error" + e.getMessage());
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
}
